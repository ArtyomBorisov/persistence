package com.pdp.persistence.strategy.impl;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.common.Sorting;
import com.pdp.persistence.dao.mybatis.mapper.ClientInfoDataMapper;
import com.pdp.persistence.dao.mybatis.model.ClientInfoModel;
import com.pdp.persistence.dto.ClientInfoDto;
import com.pdp.persistence.mapper.ClientInfoMapper;
import com.pdp.persistence.strategy.ClientInfoStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientInfoMybatisStrategy implements ClientInfoStrategy {

    private final ClientInfoDataMapper clientInfoDataMapper;
    private final ClientInfoMapper clientInfoMapper;

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(UUID id) {
        return clientInfoDataMapper.existsById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientInfoDto> findByIds(List<UUID> ids) {
        return clientInfoMapper.mapClientInfoModelsToDtos(clientInfoDataMapper.findByIds(ids));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientInfoDto> findWithNameLike(String name) {
        return clientInfoMapper.mapClientInfoModelsToDtos(clientInfoDataMapper.findWithNameLike(name));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientInfoDto> findSortingByName(Sorting sorting) {
        return clientInfoMapper.mapClientInfoModelsToDtos(clientInfoDataMapper.findSortingByName(sorting));
    }

    @Transactional
    @Override
    public void save(ClientInfoDto clientInfo) {
        clientInfoDataMapper.save(clientInfoMapper.mapClientInfoDtoToModel(clientInfo));
    }

    @Override
    public Framework getFramework() {
        return Framework.MYBATIS;
    }
}
