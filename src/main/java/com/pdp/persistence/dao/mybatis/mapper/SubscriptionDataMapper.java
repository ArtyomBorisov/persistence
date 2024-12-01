package com.pdp.persistence.dao.mybatis.mapper;

import com.pdp.persistence.dao.mybatis.model.SubscriptionModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface SubscriptionDataMapper {

    @Select("""
            SELECT ID,
                   TITLE,
                   DESCRIPTION
            FROM SUBSCRIPTION
            WHERE id = #{id};
            """)
    Optional<SubscriptionModel> findById(@Param("id") UUID id);
}
