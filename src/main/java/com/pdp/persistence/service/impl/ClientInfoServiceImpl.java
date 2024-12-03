package com.pdp.persistence.service.impl;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.common.Sorting;
import com.pdp.persistence.dto.ClientInfoDto;
import com.pdp.persistence.service.ClientInfoService;
import com.pdp.persistence.strategy.ClientInfoStrategy;
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
public class ClientInfoServiceImpl implements ClientInfoService {

    private final Map<Framework, ClientInfoStrategy> clientInfoStrategies;

    @Override
    public boolean existsById(UUID id, Framework framework) {
        final var clientInfoStrategy = getClientInfoStrategy(framework);
        return clientInfoStrategy.existsById(id);
    }

    @Override
    public List<ClientInfoDto> findByIds(List<UUID> ids, Framework framework) {
        final var clientInfoStrategy = getClientInfoStrategy(framework);
        return clientInfoStrategy.findByIds(ids);
    }

    @Override
    public List<ClientInfoDto> findWithNameLike(String name, Framework framework) {
        final var clientInfoStrategy = getClientInfoStrategy(framework);
        return clientInfoStrategy.findWithNameLike(name);
    }

    @Override
    public List<ClientInfoDto> findSortingByName(Sorting sorting, Framework framework) {
        final var clientInfoStrategy = getClientInfoStrategy(framework);
        return clientInfoStrategy.findSortingByName(sorting);
    }

    @Override
    public void save(ClientInfoDto clientInfo, Framework framework) {
        final var clientInfoStrategy = getClientInfoStrategy(framework);
        clientInfoStrategy.save(clientInfo);
    }

    private ClientInfoStrategy getClientInfoStrategy(Framework framework) {
        return Optional.ofNullable(clientInfoStrategies.get(framework))
                .orElseThrow(() -> {
                    final var message = "Отсутствует реализация ClientInfoStrategy с типом " + framework.name();
                    log.error(message);
                    return new IllegalStateException(message);
                });
    }
}
