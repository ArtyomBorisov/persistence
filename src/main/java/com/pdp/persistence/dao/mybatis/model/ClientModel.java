package com.pdp.persistence.dao.mybatis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ClientModel {
    private UUID id;
    private ClientInfoModel clientInfo;
    private String identificationNumber;
}
