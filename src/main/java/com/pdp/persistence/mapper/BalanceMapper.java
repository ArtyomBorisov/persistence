package com.pdp.persistence.mapper;

import com.pdp.persistence.dao.hibernate.entity.BalanceEntity;
import com.pdp.persistence.dao.mybatis.model.BalanceModel;
import com.pdp.persistence.dto.BalanceDto;
import org.mapstruct.Mapper;

@Mapper
public interface BalanceMapper {

    BalanceDto mapBalanceEntityToDto(BalanceEntity balanceEntity);

    BalanceDto mapBalanceModelToDto(BalanceModel balanceModel);
}
