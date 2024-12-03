package com.pdp.persistence.strategy.impl;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dao.hibernate.repository.ClientRepository;
import com.pdp.persistence.dto.ClientDto;
import com.pdp.persistence.exception.MessageConstant;
import com.pdp.persistence.exception.NotFound;
import com.pdp.persistence.mapper.ClientMapper;
import com.pdp.persistence.strategy.ClientStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientHibernateStrategy implements ClientStrategy {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Transactional(readOnly = true)
    @Override
    public ClientDto findById(UUID id) {
        final var clientEntity = clientRepository.findById(id)
                .orElseThrow(() -> buildException(String.format(MessageConstant.CLIENT_NOT_FOUND, id)));
        return clientMapper.mapClientEntityToDto(clientEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientDto> findAll() {
        return clientMapper.mapClientEntitiesToDtos(clientRepository.findAll());
    }

    // todo save client info
    @Transactional
    @Override
    public void save(ClientDto clientDto) {
        clientRepository.save(clientMapper.mapClientDtoToEntity(clientDto));
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    @Override
    public ClientDto update(ClientDto clientDto) {
        final var id = clientDto.id();
        final var clientEntity = clientRepository.findById(id)
                .orElseThrow(() -> buildException(String.format(MessageConstant.CLIENT_NOT_FOUND, id)));
        clientEntity.setIdentificationNumber(clientDto.identificationNumber());
        // clientEntity.setClientInfo();
        final var updatedClientEntity = clientRepository.save(clientEntity);
        return clientMapper.mapClientEntityToDto(updatedClientEntity);
    }

    @Override
    public Framework getFramework() {
        return Framework.HIBERNATE;
    }

    private NotFound buildException(String message) {
        log.error(message);
        return new NotFound(message);
    }
}
