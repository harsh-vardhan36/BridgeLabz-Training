package com.fundoo.notes.specification;

import org.springframework.data.jpa.domain.Specification;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;

// Small, composable building blocks for the /api/notes/search endpoint.
// Tags are filtered in-memory in the service layer instead of here (see
// NoteServiceImpl.searchNotes) — a Criteria subquery for "match ALL tags"
// over an @ElementCollection gets messy fast, and note counts per user are
// small enough that a stream filter is simpler and just as fast in practice.
public final class NoteSpecifications {

    private NoteSpecifications() {
    }

    public static Specification<Note> belongsToUser(User user) {
        return (root, query, cb) -> cb.equal(root.get("user"), user);
    }

    public static Specification<Note> hasState(Note.NoteState state) {
        return (root, query, cb) -> cb.equal(root.get("state"), state);
    }

    public static Specification<Note> titleOrContentContains(String keyword) {
        String pattern = "%" + keyword.toLowerCase() + "%";
        return (root, query, cb) -> cb.or(
                cb.like(cb.lower(root.get("title")), pattern),
                cb.like(cb.lower(root.get("content")), pattern)
        );
    }
}
