package com.pdp.persistence.dao.hibernate.entity;

import jakarta.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "client_info_id")
    private ClientInfoEntity clientInfo;

    @Column(nullable = false)
    private String identificationNumber;
}
