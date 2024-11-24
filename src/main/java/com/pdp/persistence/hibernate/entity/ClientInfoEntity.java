package com.pdp.persistence.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "client_info")
@Getter
public class ClientInfoEntity {

    @Id
    private UUID id;

    @OneToOne
    private ClientEntity client;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;
}
