package com.tpass.server.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "credentials")
@Data
public class CredentialsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


}
