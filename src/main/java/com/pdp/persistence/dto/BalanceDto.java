package com.pdp.persistence.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record BalanceDto(UUID id,
                         BigDecimal amount) {
}
