package com.pdp.persistence.dao.mybatis.mapper;

import com.pdp.persistence.dao.mybatis.model.ClientModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface ClientDataMapper {

    //todo add
    @Select("""
            SELECT ID,
                   IDENTIFICATION_NUMBER
            FROM CLIENT;
            """)
    @Results
    Optional<ClientModel> findById(@Param("id") UUID id);

    @Select("""
            SELECT ID,
                   IDENTIFICATION_NUMBER
            FROM CLIENT
            WHERE ID = #{id};
            """)
    List<ClientModel> findAll();

    @Insert("""
            INSERT INTO CLIENT (ID, IDENTIFICATION_NUMBER)
            VALUES (#{clientModel.id}, #{clientModel.identificationNumber});
            """)
    void save(ClientModel clientModel);
}
