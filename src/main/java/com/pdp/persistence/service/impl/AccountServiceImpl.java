package com.pdp.persistence.service.impl;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dto.AccountDto;
import com.pdp.persistence.dto.BalanceDto;
import com.pdp.persistence.service.AccountService;
import com.pdp.persistence.strategy.AccountStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final Map<Framework, AccountStrategy> accountStrategies;

    @Override
    public AccountDto findAccountById(UUID id, Framework framework) {
        final var accountStrategy = accountStrategies.get(framework);
        return accountStrategy.findById(id);
    }

    @Override
    public BalanceDto findBalanceById(UUID id, Framework framework) {
        final var accountStrategy = accountStrategies.get(framework);
        return accountStrategy.findBalanceById(id);
    }

    @Override
    public List<AccountDto> findAllAccounts(Framework framework) {
        final var accountStrategy = accountStrategies.get(framework);
        return accountStrategy.findAll();
    }

    @Override
    public List<BalanceDto> findAllBalances(Framework framework) {
        final var accountStrategy = accountStrategies.get(framework);
        return accountStrategy.findAllBalances();
    }
}
