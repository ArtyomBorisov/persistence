package com.pdp.persistence.dao.mybatis.model;

import com.pdp.persistence.common.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class AccountModel {

    private UUID id;
    private BalanceModel balance;
    private ClientModel client;
    private List<SubscriptionModel> subscriptions;
    private String number;
    private AccountType accountType;
}
