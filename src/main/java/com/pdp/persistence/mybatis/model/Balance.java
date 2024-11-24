package com.pdp.persistence.mybatis.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Balance(UUID id,
                      Account account,
                      BigDecimal amount) {
}
