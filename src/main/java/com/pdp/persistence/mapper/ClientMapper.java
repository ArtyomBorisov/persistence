package com.pdp.persistence.mapper;

import com.pdp.persistence.dao.hibernate.entity.ClientEntity;
import com.pdp.persistence.dao.mybatis.model.ClientModel;
import com.pdp.persistence.dto.ClientDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ClientMapper {

    ClientEntity mapClientDtoToEntity(ClientDto clientDto);

    ClientDto mapClientEntityToDto(ClientEntity clientEntity);

    List<ClientDto> mapClientEntitiesToDtos(List<ClientEntity> clientEntities);

    ClientModel mapClientDtoToModel(ClientDto clientDto);

    ClientDto mapClientModelToDto(ClientModel clientModel);

    List<ClientDto> mapClientModelsToDtos(List<ClientModel> clientModels);
}
