package com.tpass.server.models;

import com.tpass.server.enums.UserLogTypeEnum;
import com.tpass.server.utilities.Time;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Table(name = "access_logs")
@Data
public class UserLogsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(name = "log_time", nullable = false)
    private Timestamp logTime;

    @Column(name = "log_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserLogTypeEnum logType;

    @Column(name = "ip_address", length = 16)
    private String ipAddress;

    private String location;

    @Column(name = "last_remember_me_time")
    private Timestamp lastRememberMeOnThisIp; // if null remember me is/was off.

    @PrePersist
    public void onCreate() {
        this.logTime = Time.getCurrentTimestamp();
        this.logType = UserLogTypeEnum.INIT_ERROR;
        this.location = "-";
    }
}
