package com.pdp.persistence.mapper;

import com.pdp.persistence.dao.hibernate.entity.ClientEntity;
import com.pdp.persistence.dao.mybatis.model.ClientModel;
import com.pdp.persistence.dto.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = ClientInfoMapper.class)
public interface ClientMapper {

    ClientEntity mapClientDtoToEntity(ClientDto clientDto);

    ClientDto mapClientEntityToDto(ClientEntity clientEntity);

    List<ClientDto> mapClientEntitiesToDtos(List<ClientEntity> clientEntities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "clientInfo", source = "clientInfo")
    @Mapping(target = "identificationNumber", source = "identificationNumber")
    ClientModel mapClientDtoToModel(ClientDto clientDto);

    ClientDto mapClientModelToDto(ClientModel clientModel);

    List<ClientDto> mapClientModelsToDtos(List<ClientModel> clientModels);
}
