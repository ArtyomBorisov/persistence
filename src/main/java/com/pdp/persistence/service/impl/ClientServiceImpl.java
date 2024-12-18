package com.pdp.persistence.service.impl;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dto.ClientDto;
import com.pdp.persistence.service.ClientService;
import com.pdp.persistence.strategy.ClientStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final Map<Framework, ClientStrategy> clientStrategies;

    @Override
    public ClientDto findById(UUID id, Framework framework) {
        final var clientStrategy = getClientStrategy(framework);
        return clientStrategy.findById(id);
    }

    @Override
    public List<ClientDto> findAll(Framework framework) {
        final var clientStrategy = getClientStrategy(framework);
        return clientStrategy.findAll();
    }

    @Override
    public void save(ClientDto clientDto, Framework framework) {
        final var clientStrategy = getClientStrategy(framework);
        clientStrategy.save(clientDto);
    }

    @Override
    public void deleteById(UUID id, Framework framework) {
        final var clientStrategy = getClientStrategy(framework);
        clientStrategy.deleteById(id);
    }

    @Override
    public ClientDto update(ClientDto clientDto, Framework framework) {
        final var clientStrategy = getClientStrategy(framework);
        return clientStrategy.update(clientDto);
    }

    private ClientStrategy getClientStrategy(Framework framework) {
        return Optional.ofNullable(clientStrategies.get(framework))
                .orElseThrow(() -> {
                    final var message = "Отсутствует реализация ClientStrategy с типом " + framework.name();
                    log.error(message);
                    return new IllegalStateException(message);
                });
    }
}
