package com.pdp.persistence.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "subscription")
@Getter
public class SubscriptionEntity {

    @Id
    @UuidGenerator
    private UUID id;

    //@ManyToMany
    //@JoinTable(name = "account_subscription",
    //        joinColumns = @JoinColumn(name = "subscription_id"),
    //        inverseJoinColumns = @JoinColumn(name = "account_id"))
    //private List<AccountEntity> accounts;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;
}
