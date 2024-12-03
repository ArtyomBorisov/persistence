package com.pdp.persistence.dao.mybatis.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JoinMapping {
    public static final String FIND_BALANCE_BY_ID = "com.pdp.persistence.dao.mybatis.mapper.BalanceDataMapper.findById";
    public static final String FIND_CLIENT_BY_ID = "com.pdp.persistence.dao.mybatis.mapper.ClientDataMapper.findById";
    public static final String FIND_SUBSCRIPTIONS_BY_ACCOUNT_ID = "com.pdp.persistence.dao.mybatis.mapper.SubscriptionDataMapper.findAllByAccountId";
    public static final String FIND_CLIENT_INFO_BY_ID = "com.pdp.persistence.dao.mybatis.mapper.ClientInfoDataMapper.findById";
}
