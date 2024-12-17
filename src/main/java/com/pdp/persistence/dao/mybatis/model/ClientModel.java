package com.pdp.persistence.dao.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ClientModel {
    private UUID id;
    private ClientInfoModel clientInfo;
    private String identificationNumber;
}
