package com.pdp.persistence.dao.mybatis.mapper;

import com.pdp.persistence.common.Sorting;
import com.pdp.persistence.dao.mybatis.model.ClientInfoModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface ClientInfoDataMapper {

    @Select("""
            SELECT ID,
                   NAME,
                   SURNAME
            FROM CLIENT_INFO
            WHERE ID = #{id};
            """)
    Optional<ClientInfoModel> findById(@Param("id") UUID id);

    @Select("SELECT EXISTS (SELECT 1 FROM CLIENT_INFO WHERE ID = #{id});")
    boolean existsById(UUID id);

    @Select("""
            <script>
            SELECT ID,
                   NAME,
                   SURNAME
            FROM CLIENT_INFO
            <if test="ids != null and ids.size > 0">
                WHERE ID IN
                <foreach collection='ids' item='id' open='(' separator=',' close=');'>
                    #{id}
                </foreach>
            </if>
            </script>
            """)
    List<ClientInfoModel> findByIds(List<UUID> ids);

    @Select("""
            SELECT ID,
                   NAME,
                   SURNAME
            FROM CLIENT_INFO
            WHERE NAME ILIKE #{name};
            """)
    List<ClientInfoModel> findWithNameLike(String name);

    @Select("""
            SELECT ID,
                   NAME,
                   SURNAME
            FROM CLIENT_INFO
            ORDER BY NAME
            <choose>
              <when test="sorting != null">
                #{sorting}
              </when>
              <otherwise>
                ASC
              </otherwise>
            </choose>
            """)
    List<ClientInfoModel> findSortingByName(Sorting sorting);

    @Insert("""
            INSERT INTO CLIENT_INFO (ID, NAME, SURNAME)
            VALUES (#{clientInfoModel.id}, #{clientInfoModel.name}, #{clientInfoModel.surname});
            """)
    void save(ClientInfoModel clientInfoModel);
}
