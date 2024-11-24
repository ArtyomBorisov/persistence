package com.pdp.persistence.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")
@Getter
public class ClientEntity {

    @Id
    private UUID id;

    @OneToMany
    private List<AccountEntity> accounts;

    @Column(nullable = false)
    private String identificationNumber;
}
