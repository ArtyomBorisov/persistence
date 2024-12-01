package com.pdp.persistence.dao.hibernate.repository;

import com.pdp.persistence.dao.hibernate.entity.ClientInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientInfoRepository extends JpaRepository<ClientInfoEntity, UUID> {

    List<ClientInfoEntity> findByNameLikeIgnoreCase(String name);


}
