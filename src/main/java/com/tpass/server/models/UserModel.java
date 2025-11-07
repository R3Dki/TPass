package com.tpass.server.models;

import com.tpass.server.utilities.Time;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

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


    @PrePersist
    public void onCreate() {
        registrationTime = Time.getCurrentTimestamp();
    }
}
