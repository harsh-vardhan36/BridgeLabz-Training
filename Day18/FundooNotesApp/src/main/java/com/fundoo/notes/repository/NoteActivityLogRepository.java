package com.fundoo.notes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundoo.notes.entity.NoteActivityLog;

@Repository
public interface NoteActivityLogRepository extends JpaRepository<NoteActivityLog, Long> {
    List<NoteActivityLog> findByUsernameOrderByTimestampDesc(String username);
}
