package com.pdp.persistence.strategy.impl;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dao.mybatis.mapper.ClientDataMapper;
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
public class ClientMybatisStrategy implements ClientStrategy {

    private final ClientInfoMybatisStrategy clientInfoMybatisStrategy;
    private final ClientDataMapper clientDataMapper;
    private final ClientMapper clientMapper;

    @Transactional(readOnly = true)
    @Override
    public ClientDto findClientById(UUID id) {
        final var clientModel = clientDataMapper.findById(id)
                .orElseThrow(() -> buildException(String.format(MessageConstant.CLIENT_NOT_FOUND, id)));
        return clientMapper.mapClientModelToDto(clientModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientDto> findAll() {
        return clientMapper.mapClientModelsToDtos(clientDataMapper.findAll());
    }

    @Transactional
    @Override
    public void save(ClientDto clientDto) {
        clientInfoMybatisStrategy.save(clientDto.clientInfo());
        clientDataMapper.save(clientMapper.mapClientDtoToModel(clientDto));
    }

    @Override
    public Framework getFramework() {
        return Framework.MYBATIS;
    }

    private NotFound buildException(String message) {
        log.error(message);
        return new NotFound(message);
    }
}
