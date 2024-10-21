package com.redis_cache_with_mysql.controller;

import com.redis_cache_with_mysql.entity.Notes;
import com.redis_cache_with_mysql.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NotesService notesService;

    // CREATE Operation - Create a new note
    @PostMapping
    public ResponseEntity<Notes> createNote(@RequestBody Notes note) {
        Notes createdNote = notesService.save(note);
        return ResponseEntity.ok(createdNote);
    }

    // READ Operation - Get a note by ID
    @GetMapping("/{id}")
    public ResponseEntity<Notes> getNoteById(@PathVariable String id) {
        Notes note = notesService.getNoteById(id);
        return ResponseEntity.ok(note);
    }

    // READ Operation - Get all notes
    @GetMapping
    public ResponseEntity<List<Notes>> getAllNotes() {
        List<Notes> notes = notesService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    // UPDATE Operation - Update an existing note
    @PutMapping("/{id}")
    public ResponseEntity<Notes> updateNote(@PathVariable String id, @RequestBody Notes noteDetails) {
        Notes updatedNote = notesService.updateNote(id, noteDetails);
        return ResponseEntity.ok(updatedNote);
    }

    // DELETE Operation - Delete a note by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable String id) {
        notesService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
}
