package com.pdp.persistence.mapper;

import com.pdp.persistence.dao.hibernate.entity.AccountEntity;
import com.pdp.persistence.dao.mybatis.model.AccountModel;
import com.pdp.persistence.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = BalanceMapper.class)
public interface AccountMapper {

    AccountDto mapAccountEntityToDto(AccountEntity accountEntity);

    List<AccountDto> mapAccountEntitiesToDtos(List<AccountEntity> accountEntities);

    @Mapping(target = "id", source = "id")
    AccountDto mapAccountModelToDto(AccountModel accountModel);

    List<AccountDto> mapAccountModelsToDtos(List<AccountModel> accountModels);
}
