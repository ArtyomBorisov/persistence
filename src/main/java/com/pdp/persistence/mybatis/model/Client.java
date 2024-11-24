package com.pdp.persistence.mybatis.model;

import java.util.List;
import java.util.UUID;

public record Client(UUID id,
                     List<Account> accounts,
                     String identificationNumber) {
}
