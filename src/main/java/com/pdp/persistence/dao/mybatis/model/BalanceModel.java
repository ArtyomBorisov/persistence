package com.pdp.persistence.dao.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class BalanceModel {
    private UUID id;
    private BigDecimal amount;
}
