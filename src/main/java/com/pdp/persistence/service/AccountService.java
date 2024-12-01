package com.pdp.persistence.service;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dto.AccountDto;
import com.pdp.persistence.dto.BalanceDto;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    AccountDto findAccountById(UUID id, Framework framework);

    BalanceDto findBalanceById(UUID id, Framework framework);

    List<AccountDto> findAllAccounts(Framework framework);

    List<BalanceDto> findAllBalances(Framework framework);
}
