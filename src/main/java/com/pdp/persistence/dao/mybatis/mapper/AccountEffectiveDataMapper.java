package com.pdp.persistence.dao.mybatis.mapper;

import com.pdp.persistence.dao.mybatis.model.AccountModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountEffectiveDataMapper {

    @Select("""
            SELECT a.ID,
                   a.NUMBER,
                   a.TYPE,
                   b.ID                    as b_ID,
                   b.AMOUNT                as b_AMOUNT,
                   c.ID                    as c_ID,
                   c.IDENTIFICATION_NUMBER as c_IDENTIFICATION_NUMBER,
                   ci.ID                   as c_ci_ID,
                   ci.NAME                 as c_ci_NAME,
                   ci.SURNAME              as c_ci_SURNAME,
                   s.id                    as s_ID,
                   s.title                 as s_TITLE,
                   s.description           as s_DESCRIPTION
            FROM ACCOUNT a
                LEFT JOIN BALANCE b USING(ID)
                LEFT JOIN CLIENT c ON c.ID = a.CLIENT_ID
                LEFT JOIN CLIENT_INFO ci ON ci.ID = c.CLIENT_INFO_ID
                LEFT JOIN ACCOUNT_SUBSCRIPTION_LINK asl ON asl.ACCOUNT_ID = a.ID
                LEFT JOIN SUBSCRIPTION s ON s.ID = asl.SUBSCRIPTION_ID;
            """)
    @ResultMap("accountResultMap")
    List<AccountModel> findAll();
}
