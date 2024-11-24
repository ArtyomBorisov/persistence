package com.pdp.persistence.mybatis.model;

import java.util.UUID;

public record ClientInfo(UUID id,
                         Client client,
                         String name,
                         String surname) {
}
