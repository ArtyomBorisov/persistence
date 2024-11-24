package com.pdp.persistence.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
