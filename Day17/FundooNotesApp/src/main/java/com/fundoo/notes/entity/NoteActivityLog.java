package com.fundoo.notes.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Durable record of NoteActivityEvent messages, written by
 * NoteActivityListener as it drains the RabbitMQ activity queue.
 * This is the audit trail: "who did what to which note, and when".
 */
@Data
@Entity
@Table(name = "note_activity_log")
public class NoteActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String action;

    private Integer noteNumber;

    private String noteTitle;

    @Column(nullable = false)
    private LocalDateTime timestamp;
}
