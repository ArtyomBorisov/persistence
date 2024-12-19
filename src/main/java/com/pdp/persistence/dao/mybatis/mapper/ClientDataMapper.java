package com.pdp.persistence.dao.mybatis.mapper;

import com.pdp.persistence.dao.mybatis.model.ClientModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface ClientDataMapper {

    @Select("""
            SELECT ID,
                   CLIENT_INFO_ID,
                   IDENTIFICATION_NUMBER
            FROM CLIENT
            WHERE ID = #{id};
            """)
    @Results(value = {
            @Result(property = "id", column = "ID", id = true),
            @Result(property = "identificationNumber", column = "IDENTIFICATION_NUMBER"),
            @Result(property = "clientInfo", column = "CLIENT_INFO_ID", one = @One(select = JoinMapping.FIND_CLIENT_INFO_BY_ID))
    })
    Optional<ClientModel> findById(@Param("id") UUID id);

    @Select("""
            SELECT ID,
                   CLIENT_INFO_ID,
                   IDENTIFICATION_NUMBER
            FROM CLIENT;
            """)
    @Results(value = {
            @Result(property = "id", column = "ID", id = true),
            @Result(property = "identificationNumber", column = "IDENTIFICATION_NUMBER"),
            @Result(property = "clientInfo", column = "CLIENT_INFO_ID", one = @One(select = JoinMapping.FIND_CLIENT_INFO_BY_ID))
    })
    List<ClientModel> findAll();

    @Insert("""
            INSERT INTO CLIENT (ID, CLIENT_INFO_ID, IDENTIFICATION_NUMBER)
            VALUES (#{clientModel.id}, #{clientInfoId}, #{clientModel.identificationNumber});
            """)
    void save(@Param("clientModel") ClientModel clientModel,
              @Param("clientInfoId") UUID clientInfoId);

    @Delete("""
            DELETE FROM CLIENT
            WHERE ID = #{id};
            """)
    boolean deleteById(UUID id);

    @Select("""
            UPDATE CLIENT
            SET IDENTIFICATION_NUMBER = ${cm.identificationNumber}
            WHERE ID = #{id}
            RETURNING ID, CLIENT_INFO_ID, IDENTIFICATION_NUMBER;
            """)
    ClientModel update(@Param("id") UUID id,
                       @Param("cm") ClientModel clientModel);
}
