package com.pdp.persistence.mybatis.model;

import com.pdp.persistence.common.AccountType;

import java.util.UUID;

public record Account(UUID id,
                      UUID clientId,
                      Balance balance,
                      Client clientInfo,
                      String number,
                      AccountType accountType) {
}
