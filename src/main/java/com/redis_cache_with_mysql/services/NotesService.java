package com.redis_cache_with_mysql.services;

import com.redis_cache_with_mysql.entity.Notes;
import com.redis_cache_with_mysql.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotesService {

    @Autowired
    private NoteRepo noteRepo;

    @CachePut(value = "notes", key = "#note.id")
    public Notes save(Notes note) {
        note.setId(UUID.randomUUID().toString());
        return noteRepo.save(note);
    }

    @Cacheable(value = "notes",key = "#id")
    public Notes getNoteById(String id){
        return noteRepo.findById(id).orElseThrow(()-> new RuntimeException("note with this given id not found"));

    }

    // READ Operation - Get all notes
    public List<Notes> getAllNotes() {
        return noteRepo.findAll();
    }

    // UPDATE Operation - Update a note
    public Notes updateNote(String id, Notes noteDetails) {
        Notes existingNote = noteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note with this given ID not found"));

        // Update fields of the existing note
        existingNote.setTitle(noteDetails.getTitle());
        existingNote.setContent(noteDetails.getContent());
        existingNote.setAddedNote(noteDetails.getAddedNote());
        existingNote.setLive(noteDetails.isLive());
        // Save the updated note back to the repository
        return noteRepo.save(existingNote);

    }

    // DELETE operation
    @CacheEvict(value = "notes", key = "#id")
    public void deleteNoteById(String id) {
        Notes existingNote = noteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note with this given ID not found"));
        noteRepo.delete(existingNote);
    }

}
