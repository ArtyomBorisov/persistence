package com.pdp.persistence.mybatis.model;

import com.pdp.persistence.common.AccountType;

import java.util.List;
import java.util.UUID;

public record Account(UUID id,
                      Balance balance,
                      Client client,
                      List<Subscription> subscriptions,
                      String number,
                      AccountType accountType) {
}
