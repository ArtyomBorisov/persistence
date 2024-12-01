package com.pdp.persistence.dao.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SubscriptionModel {
    private UUID id;
    private String title;
    private String description;
}
