package com.pdp.persistence.strategy;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dto.AccountDto;

import java.util.List;
import java.util.UUID;

public interface AccountStrategy {

    AccountDto findById(UUID id);

    List<AccountDto> findAll();

    Framework getFramework();
}
