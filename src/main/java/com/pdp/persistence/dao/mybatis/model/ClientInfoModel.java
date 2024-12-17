package com.pdp.persistence.dao.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ClientInfoModel {
    private UUID id;
    private String name;
    private String surname;
}
