package com.pdp.persistence.dao.hibernate.entity;

import com.pdp.persistence.common.AccountType;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
public class AccountEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private BalanceEntity balance;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private ClientEntity client;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_subscription_link",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id"))
    private List<SubscriptionEntity> subscriptions;

    @Column(nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private AccountType accountType;
}
