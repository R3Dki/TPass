package com.tpass.server.models;

import com.tpass.server.utilities.Time;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class UserModel {
    @Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(nullable = false)
    private String password;

    // Emails are not unique but there is a 5 or n email account limit
    @Column(nullable = false)
    private String email;

    @Column(name = "registration_time", nullable = false)
    private Timestamp registrationTime;


    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CredentialsModel> credentials = new HashSet<>();

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CreditCardModel> creditCards = new HashSet<>();

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<NoteModel> notes = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserLogsModel> userLogs = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AuthCodeModel> authCodes = new HashSet<>();


    @PrePersist
    public void onCreate() {
        registrationTime = Time.getCurrentTimestamp();
    }
}
