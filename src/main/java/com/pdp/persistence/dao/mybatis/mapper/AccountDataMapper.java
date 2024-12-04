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
            @Result(property = "balance", column = "ID", one = @One(select = JoinMapping.FIND_BALANCE_BY_ID)),
            @Result(property = "client", column = "CLIENT_ID", one = @One(select = JoinMapping.FIND_CLIENT_BY_ID)),
            @Result(property = "subscriptions", column = "ID", many = @Many(select = JoinMapping.FIND_SUBSCRIPTIONS_BY_ACCOUNT_ID))
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
            @Result(property = "balance", column = "ID", one = @One(select = JoinMapping.FIND_BALANCE_BY_ID)),
            @Result(property = "client", column = "CLIENT_ID", one = @One(select = JoinMapping.FIND_CLIENT_BY_ID)),
            @Result(property = "subscriptions", column = "ID", many = @Many(select = JoinMapping.FIND_SUBSCRIPTIONS_BY_ACCOUNT_ID))
    })
    List<AccountModel> findAll();

    @Select("""
            SELECT a.ID,
                   a.NUMBER,
                   a.TYPE,
                   b.ID                    as b_ID,
                   b.AMOUNT                as b_AMOUNT,
                   c.ID                    as c_ID,
                   c.IDENTIFICATION_NUMBER as c_IDENTIFICATION_NUMBER,
                   ci.ID                   as ci_ID,
                   ci.NAME                 as ci_NAME,
                   ci.SURNAME              as ci_SURNAME,
                   s.id                    as s_ID,
                   s.title                 as s_TITLE,
                   s.description           as s_DESCRIPTION
            FROM ACCOUNT a
                LEFT JOIN BALANCE b USING(ID)
                LEFT JOIN CLIENT c ON c.ID = a.CLIENT_ID
                LEFT JOIN CLIENT_INFO ci ON ci.ID = c.CLIENT_INFO_ID
                LEFT JOIN ACCOUNT_SUBSCRIPTION_LINK asl ON asl.ACCOUNT_ID = a.ID
                INNER JOIN SUBSCRIPTION s ON s.ID = asl.SUBSCRIPTION_ID;
            """)
    @ResultMap("accountResultMap")
    List<AccountModel> findAllEffectively();
}
