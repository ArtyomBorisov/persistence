package com.pdp.persistence.mapper;

import com.pdp.persistence.dao.hibernate.entity.ClientInfoEntity;
import com.pdp.persistence.dao.mybatis.model.ClientInfoModel;
import com.pdp.persistence.dto.ClientInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ClientInfoMapper {

    ClientInfoEntity mapClientInfoDtoToEntity(ClientInfoDto clientInfoDto);

    ClientInfoDto mapClientInfoEntityToDto(ClientInfoEntity clientInfoEntity);

    List<ClientInfoDto> mapClientInfoEntitiesToDtos(List<ClientInfoEntity> clientInfoEntities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    ClientInfoModel mapClientInfoDtoToModel(ClientInfoDto clientInfoDto);

    ClientInfoDto mapClientInfoModelToDto(ClientInfoModel clientInfoModel);

    List<ClientInfoDto> mapClientInfoModelsToDtos(List<ClientInfoModel> clientInfoModels);
}
