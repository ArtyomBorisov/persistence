package com.pdp.persistence.dao.hibernate.entity;

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

    @Column(nullable = false)
    private BigDecimal amount;
}
