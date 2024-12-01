package com.pdp.persistence.mapper;

import com.pdp.persistence.dao.hibernate.entity.BalanceEntity;
import com.pdp.persistence.dao.mybatis.model.BalanceModel;
import com.pdp.persistence.dto.BalanceDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BalanceMapper {

    BalanceDto mapBalanceEntityToDto(BalanceEntity balanceEntity);

    List<BalanceDto> mapBalanceEntitiesToDtos(List<BalanceEntity> balanceEntities);

    BalanceDto mapBalanceModelToDto(BalanceModel balanceModel);

    List<BalanceDto> mapBalanceModelsToDtos(List<BalanceModel> balanceModels);
}
