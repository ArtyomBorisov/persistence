package com.pdp.persistence.strategy.impl;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dao.hibernate.repository.AccountEffectiveRepository;
import com.pdp.persistence.dao.hibernate.repository.AccountRepository;
import com.pdp.persistence.dto.AccountDto;
import com.pdp.persistence.exception.MessageConstant;
import com.pdp.persistence.exception.NotFound;
import com.pdp.persistence.mapper.AccountMapper;
import com.pdp.persistence.strategy.AccountStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountHibernateStrategy implements AccountStrategy {

    private final AccountRepository accountRepository;
    private final AccountEffectiveRepository accountEffectiveRepository;
    private final AccountMapper accountMapper;

    @Transactional(readOnly = true)
    @Override
    public AccountDto findById(UUID id) {
        final var accountEntity = accountRepository.findById(id)
                .orElseThrow(() -> buildException(String.format(MessageConstant.ACCOUNT_NOT_FOUND, id)));
        return accountMapper.mapAccountEntityToDto(accountEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountDto> findAll() {
        return accountMapper.mapAccountEntitiesToDtos(accountRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountDto> findAllEffectively() {
        return accountMapper.mapAccountEntitiesToDtos(accountEffectiveRepository.findAll());
    }

    @Override
    public Framework getFramework() {
        return Framework.HIBERNATE;
    }

    private NotFound buildException(String message) {
        log.error(message);
        return new NotFound(message);
    }
}
