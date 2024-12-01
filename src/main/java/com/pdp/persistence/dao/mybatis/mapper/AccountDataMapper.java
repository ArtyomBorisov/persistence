package com.pdp.persistence.dao.mybatis.mapper;

import com.pdp.persistence.dao.mybatis.model.AccountModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface AccountDataMapper {

    @Select("""
            SELECT ID,
                   CLIENT_ID,
                   NUMBER,
                   TYPE
            FROM ACCOUNT
            WHERE ID = #{id};
            """)
    @Results(value = {
            @Result(property = "id", column = "ID", id = true),
            @Result(property = "number", column = "NUMBER"),
            @Result(property = "accountType", column = "TYPE"),
            @Result(property = "balance", column = "ID",
                    one = @One(select = "com.pdp.persistence.dao.mybatis.mapper.BalanceDataMapper.findById")),
            @Result(property = "client", column = "CLIENT_ID",
                    one = @One(select = "com.pdp.persistence.dao.mybatis.mapper.ClientDataMapper.findById"))
            // subscriptions смаппить нельзя, association через аннотации не поддерживается
    })
    Optional<AccountModel> findById(@Param("id") UUID id);

    @Select("""
            SELECT ID,
                   CLIENT_ID,
                   NUMBER,
                   TYPE
            FROM ACCOUNT;
            """)
    @Results(value = {
            @Result(property = "id", column = "ID", id = true),
            @Result(property = "number", column = "NUMBER"),
            @Result(property = "accountType", column = "TYPE"),
            @Result(property = "balance", column = "ID",
                    one = @One(select = "com.pdp.persistence.dao.mybatis.mapper.BalanceDataMapper.findById")),
            @Result(property = "client", column = "CLIENT_ID",
                    one = @One(select = "com.pdp.persistence.dao.mybatis.mapper.ClientDataMapper.findById"))
            // subscriptions смаппить нельзя, association через аннотации не поддерживается
    })
    List<AccountModel> findAll();
}
