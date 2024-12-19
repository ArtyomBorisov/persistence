package com.pdp.persistence.strategy;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dto.ClientDto;

import java.util.List;
import java.util.UUID;

public interface ClientStrategy {

    ClientDto findById(UUID id);

    List<ClientDto> findAll();

    void save(ClientDto clientDto);

    void deleteById(UUID id);

    ClientDto update(UUID id, ClientDto clientDto);

    Framework getFramework();
}
