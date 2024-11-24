package com.pdp.persistence.hibernate.entity;

import com.pdp.persistence.common.AccountType;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
public class AccountEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false)
    private UUID clientId;

    @OneToOne
    private BalanceEntity balance;

    @ManyToOne
    private ClientInfoEntity clientInfo;

    @Column(nullable = false)
    private String number;

    @Column(name = "type", nullable = false)
    private AccountType accountType;
}
