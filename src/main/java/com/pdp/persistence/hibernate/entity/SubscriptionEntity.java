package com.pdp.persistence.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "subscription")
@Getter
public class SubscriptionEntity {

    @Id
    private UUID id;

    @ManyToMany
    private List<ClientEntity> clients;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;
}
