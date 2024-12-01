package com.pdp.persistence.dao.hibernate.repository;

import com.pdp.persistence.dao.hibernate.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
}
