package com.pdp.persistence.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "client")
@Getter
public class ClientEntity {

    @Id
    @UuidGenerator
    private UUID id;

    //@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    //private List<AccountEntity> accounts;

    @Column(nullable = false)
    private String identificationNumber;
}
