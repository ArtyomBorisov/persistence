package com.pdp.persistence.service;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.common.Sorting;
import com.pdp.persistence.dto.ClientInfoDto;

import java.util.List;
import java.util.UUID;

public interface ClientInfoService {

    boolean existsById(UUID id, Framework framework);

    List<ClientInfoDto> findByIds(List<UUID> ids, Framework framework);

    List<ClientInfoDto> findWithNameLike(String name, Framework framework);

    List<ClientInfoDto> findSortingByName(Sorting sorting, Framework framework);

    void save(ClientInfoDto clientInfo, Framework framework);
}
