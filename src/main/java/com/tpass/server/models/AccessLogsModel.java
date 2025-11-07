package com.tpass.server.models;

import com.tpass.server.enums.AccessLogTypeEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "access_logs")
@Data
public class AccessLogsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserModel user;

    @Column(name = "ip_address", length = 16)
    private String ipAddress;


    @Column(name = "log_type")
    @Enumerated(EnumType.STRING)
    private AccessLogTypeEnum logType;
}
