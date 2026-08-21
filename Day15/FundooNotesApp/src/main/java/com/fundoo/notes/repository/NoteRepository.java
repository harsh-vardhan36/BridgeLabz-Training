package com.fundoo.notes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundoo.notes.dto.NoteResponseDTO;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUser(User user);
    int countByUser(User user);
    
    List<Note> findByUserAndState(User user, Note.NoteState state);
    List<Note> findByUserAndPinned(User user, boolean pinned);

    // noteNumber (not the internal DB id) is the identifier the client
    // actually sees in NoteResponseDTO, so all lookups by "note id" from the
    // API must go through this — scoped to the owning user.
    Optional<Note> findByUserAndNoteNumber(User user, Integer noteNumber);

    // Uniqueness is scoped per-user: two different users may each have a
    // note titled "Groceries", but the same user may not have two.
    boolean existsByUserAndTitleIgnoreCase(User user, String title);

    // countByUser()+1 breaks once a note has been deleted (it reissues a
    // noteNumber that still exists), so new notes must be numbered off the
    // current max instead.
    @Query("SELECT COALESCE(MAX(n.noteNumber), 0) FROM Note n WHERE n.user = :user")
    Integer findMaxNoteNumberByUser(@Param("user") User user);
}
