package com.redis_cache_with_mysql.repository;

import com.redis_cache_with_mysql.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Notes,String> {
}
