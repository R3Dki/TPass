package com.tpass.server.models;

import com.tpass.server.enums.UserLogTypeEnum;
import com.tpass.server.utilities.Random;
import com.tpass.server.utilities.Time;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Table(name = "auth_codes")
@Data
public class AuthCodeModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long Id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        private UserModel user;

        @Column(name = "creation_time", nullable = false)
        private Timestamp creationTime;

        @Column(nullable = false)
        private Integer code;

        @PrePersist
        public void onCreate() {
            this.creationTime = Time.getCurrentTimestamp();
            this.code = Random.generateAuthCode();
        }
}
