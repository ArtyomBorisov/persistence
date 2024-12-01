package com.pdp.persistence.dao.mybatis.mapper;

import com.pdp.persistence.dao.mybatis.model.BalanceModel;
import org.apache.ibatis.annotations.*;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface BalanceDataMapper {

    @Select("""
            SELECT ID,
                   AMOUNT
            FROM BALANCE
            WHERE ID = #{id};
            """)
    Optional<BalanceModel> findById(@Param("id") UUID id);
}
