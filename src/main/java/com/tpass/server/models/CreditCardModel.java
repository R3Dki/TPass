package com.tpass.server.models;

import com.tpass.server.utilities.Time;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "credit_card_credentials")
@Data
public class CreditCardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserModel owner;

    @Column(name = "number", nullable = false, unique = true, length = 20)
    private String number;

    @Column(name = "cvv", nullable = false)
    private Integer cvv;

    @Column(name = "expiration_month", nullable = false)
    private Integer expirationMonth;

    @Column(name = "expiration_year", nullable = false)
    private Integer expirationYear;

    @Column(name = "owner_name",  nullable = false, length = 50)
    private String ownerName;

    @Column(name = "creation_time", nullable = false)
    private Timestamp creationTime;


    @PrePersist
    public void onCreate() {
        this.creationTime = Time.getCurrentTimestamp();
    }
}
