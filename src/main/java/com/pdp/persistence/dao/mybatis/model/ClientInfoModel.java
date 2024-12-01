package com.pdp.persistence.dao.mybatis.model;

import java.util.UUID;

public record ClientInfoModel(UUID id,
                              String name,
                              String surname) {
}
