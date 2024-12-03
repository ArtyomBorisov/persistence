package com.pdp.persistence.service;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dto.AccountDto;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    AccountDto findById(UUID id, Framework framework);

    List<AccountDto> findAll(Framework framework);

    List<AccountDto> findAllEffectively(Framework framework);
}
