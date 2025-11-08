package com.tpass.server.models;

import com.tpass.server.utilities.Time;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "credentials")
@Data
public class CredentialsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserModel owner;

    @Column(name = "application_name", nullable = false, length = 40)
    private String applicationName;

    @Column(length = 100)
    private String website;

    @Column(length = 40)
    private String username;

    @Column(length = 100)
    private String password;

    @Column(name = "creation_time", nullable = false)
    private Timestamp creationTime;


    @PrePersist
    public void onCreate() {
        this.creationTime = Time.getCurrentTimestamp();
        this.applicationName = "Unknown";
    }
}
