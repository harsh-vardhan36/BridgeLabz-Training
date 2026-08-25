package com.fundoo.notes.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Entity
@Table(name  = "notes")
public class Note {
	
	public enum NoteState {
        ACTIVE,
        ARCHIVED,
        TRASHED
    }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private Integer noteNumber;
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NoteState state = NoteState.ACTIVE; //  default state

    private boolean pinned = false; 

	// Reminder: when set, ReminderScheduler picks this note up once
	// reminderAt has passed and reminderSent is still false, sends the
	// email, then flips reminderSent so it's never sent twice. Null
	// reminderAt means "no reminder set".
	private LocalDateTime reminderAt;
	private boolean reminderSent = false;

	// Simple string tags (normalized to lowercase/trimmed in the service layer).
	// EAGER so it's safe to read straight into the DTO without a lazy-init exception.
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "note_tags", joinColumns = @JoinColumn(name = "note_id"))
	@Column(name = "tag")
	private Set<String> tags = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
