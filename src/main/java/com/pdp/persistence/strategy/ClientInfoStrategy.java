package com.pdp.persistence.strategy;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.common.Sorting;
import com.pdp.persistence.dto.ClientInfoDto;

import java.util.List;
import java.util.UUID;

public interface ClientInfoStrategy {

    boolean existsById(UUID id);

    List<ClientInfoDto> findByIds(List<UUID> ids);

    List<ClientInfoDto> findWithNameLike(String name);

    List<ClientInfoDto> findSortingByName(Sorting sorting);

    void save(ClientInfoDto clientInfo);

    Framework getFramework();
}
