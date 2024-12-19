package com.pdp.persistence.mapper;

import com.pdp.persistence.dao.hibernate.entity.AccountEntity;
import com.pdp.persistence.dao.mybatis.model.AccountModel;
import com.pdp.persistence.dto.AccountDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = BalanceMapper.class)
public interface AccountMapper {

    AccountDto mapAccountEntityToDto(AccountEntity accountEntity);

    List<AccountDto> mapAccountEntitiesToDtos(List<AccountEntity> accountEntities);

    AccountDto mapAccountModelToDto(AccountModel accountModel);

    List<AccountDto> mapAccountModelsToDtos(List<AccountModel> accountModels);
}
