package com.pdp.persistence.service.impl;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dto.AccountDto;
import com.pdp.persistence.service.AccountService;
import com.pdp.persistence.strategy.AccountStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final Map<Framework, AccountStrategy> accountStrategies;

    @Override
    public AccountDto findById(UUID id, Framework framework) {
        final var accountStrategy = getAccountStrategy(framework);
        return accountStrategy.findById(id);
    }

    @Override
    public List<AccountDto> findAll(Framework framework) {
        final var accountStrategy = getAccountStrategy(framework);
        return accountStrategy.findAll();
    }

    @Override
    public List<AccountDto> findAllEffectively(Framework framework) {
        final var accountStrategy = getAccountStrategy(framework);
        return accountStrategy.findAllEffectively();
    }

    private AccountStrategy getAccountStrategy(Framework framework) {
        return Optional.ofNullable(accountStrategies.get(framework))
                .orElseThrow(() -> {
                    final var message = "Отсутствует реализация AccountStrategy с типом " + framework.name();
                    log.error(message);
                    return new IllegalStateException(message);
                });
    }
}
