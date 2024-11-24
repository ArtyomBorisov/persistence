package com.pdp.persistence.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "client_info")
@Getter
public class ClientInfoEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;
}
