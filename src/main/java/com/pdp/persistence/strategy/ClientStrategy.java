package com.pdp.persistence.strategy;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dto.ClientDto;

import java.util.List;
import java.util.UUID;

public interface ClientStrategy {

    ClientDto findClientById(UUID id);

    List<ClientDto> findAll();

    void save(ClientDto clientDto);

    Framework getFramework();
}
