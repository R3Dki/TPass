package com.tpass.server.models;

import com.tpass.server.enums.LogLevelEnum;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Table(name = "logs")
@Data
public class LogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "log_level")
    @Enumerated(EnumType.STRING)
    private LogLevelEnum logLevel;

    @Column(name = "event_time")
    private Timestamp eventTime;
}
