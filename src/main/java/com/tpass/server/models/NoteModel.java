package com.tpass.server.models;

import com.tpass.server.utilities.Time;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "notes")
@Data
public class NoteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserModel owner;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(name = "creation_time", nullable = false)
    private Timestamp creationTime;


    @PrePersist
    public void onCreate() {
        this.creationTime = Time.getCurrentTimestamp();
    }
}
