package com.pdp.persistence.dao.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "client")
@Getter
@Setter
public class ClientEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_info_id")
    private ClientInfoEntity clientInfo;

    @Setter
    @Column(nullable = false)
    private String identificationNumber;
}
