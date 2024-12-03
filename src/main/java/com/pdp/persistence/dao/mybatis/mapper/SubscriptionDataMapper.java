package com.pdp.persistence.dao.mybatis.mapper;

import com.pdp.persistence.dao.mybatis.model.SubscriptionModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.UUID;

@Mapper
public interface SubscriptionDataMapper {

    @Select("""
            SELECT ID,
                   TITLE,
                   DESCRIPTION
            FROM SUBSCRIPTION s
                INNER JOIN ACCOUNT_SUBSCRIPTION_LINK asl ON asl.SUBSCRIPTION_ID = s.ID
            WHERE ACCOUNT_ID = #{accountId};
            """)
    List<SubscriptionModel> findAllByAccountId(@Param("accountId") UUID accountId);
}
