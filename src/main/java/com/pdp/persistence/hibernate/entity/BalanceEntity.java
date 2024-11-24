package com.pdp.persistence.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "balance")
@Getter
public class BalanceEntity {

    @Id
    private UUID id;

    //@MapsId
    //@OneToOne(mappedBy = "balance")
    //@JoinColumn(name = "id")
    //private AccountEntity account;

    @Column(nullable = false)
    private BigDecimal amount;
}
