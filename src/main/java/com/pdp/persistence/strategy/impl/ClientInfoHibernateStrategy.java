package com.pdp.persistence.strategy.impl;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.common.Sorting;
import com.pdp.persistence.dao.hibernate.repository.ClientInfoRepository;
import com.pdp.persistence.dto.ClientInfoDto;
import com.pdp.persistence.mapper.ClientInfoMapper;
import com.pdp.persistence.strategy.ClientInfoStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientInfoHibernateStrategy implements ClientInfoStrategy {

    private final ClientInfoRepository clientInfoRepository;
    private final ClientInfoMapper clientInfoMapper;

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(UUID id) {
        return clientInfoRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientInfoDto> findByIds(List<UUID> ids) {
        return clientInfoMapper.mapClientInfoEntitiesToDtos(clientInfoRepository.findAllById(ids));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientInfoDto> findWithNameLike(String name) {
        return clientInfoMapper.mapClientInfoEntitiesToDtos(clientInfoRepository.findByNameLikeIgnoreCase(name));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientInfoDto> findSortingByName(Sorting sorting) {
        final var sortDirection = mapToSortDirection(sorting);
        final var clientInfoEntities = clientInfoRepository.findAll(Sort.by(sortDirection, "name"));
        return clientInfoMapper.mapClientInfoEntitiesToDtos(clientInfoEntities);
    }

    @Transactional
    @Override
    public void save(ClientInfoDto clientInfo) {
        clientInfoRepository.save(clientInfoMapper.mapClientInfoDtoToEntity(clientInfo));
    }

    @Override
    public Framework getFramework() {
        return Framework.HIBERNATE;
    }

    private Sort.Direction mapToSortDirection(Sorting sorting) {
        return sorting != null
                ? Sort.Direction.fromString(sorting.name())
                : Sort.DEFAULT_DIRECTION;
    }
}
