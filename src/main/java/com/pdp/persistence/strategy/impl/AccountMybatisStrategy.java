package com.pdp.persistence.strategy.impl;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dao.mybatis.mapper.AccountDataMapper;
import com.pdp.persistence.dto.AccountDto;
import com.pdp.persistence.exception.MessageConstant;
import com.pdp.persistence.exception.NotFound;
import com.pdp.persistence.dao.mybatis.mapper.AccountEffectiveDataMapper;
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
public class AccountMybatisStrategy implements AccountStrategy {

    private final AccountDataMapper accountDataMapper;
    private final AccountEffectiveDataMapper accountEffectiveDataMapper;
    private final AccountMapper accountMapper;

    @Transactional(readOnly = true)
    @Override
    public AccountDto findById(UUID id) {
        final var accountModel = accountDataMapper.findById(id)
                .orElseThrow(() -> buildException(String.format(MessageConstant.ACCOUNT_NOT_FOUND, id)));
        return accountMapper.mapAccountModelToDto(accountModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountDto> findAll() {
        return accountMapper.mapAccountModelsToDtos(accountDataMapper.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountDto> findAllEffectively() {
        return accountMapper.mapAccountModelsToDtos(accountEffectiveDataMapper.findAll());
    }

    @Override
    public Framework getFramework() {
        return Framework.MYBATIS;
    }

    private NotFound buildException(String message) {
        log.error(message);
        return new NotFound(message);
    }
}
