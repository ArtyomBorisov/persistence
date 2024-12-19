package com.pdp.persistence.service;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dto.ClientDto;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    ClientDto findById(UUID id, Framework framework);

    List<ClientDto> findAll(Framework framework);

    void save(ClientDto clientDto, Framework framework);

    void deleteById(UUID id, Framework framework);

    ClientDto update(UUID id, ClientDto clientDto, Framework framework);
}
