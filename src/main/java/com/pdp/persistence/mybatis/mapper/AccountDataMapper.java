package com.pdp.persistence.mybatis.mapper;

import com.pdp.persistence.mybatis.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountDataMapper {

    @Select("""
            SELECT * FROM ACCOUNT;
            """)
    List<Account> findAll();
}
