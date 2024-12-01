package com.pdp.persistence.dto;

import com.pdp.persistence.common.AccountType;

import java.util.List;
import java.util.UUID;

public record AccountDto(UUID id,
                         BalanceDto balance,
                         ClientDto client,
                         List<SubscriptionDto> subscriptions,
                         String number,
                         AccountType accountType) {
}
