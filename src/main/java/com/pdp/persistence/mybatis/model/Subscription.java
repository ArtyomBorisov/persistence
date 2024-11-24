package com.pdp.persistence.mybatis.model;

import java.util.List;
import java.util.UUID;

public record Subscription(UUID id,
                           List<Account> accounts,
                           String title,
                           String description) {
}
