package com.pdp.persistence.dao.hibernate.repository;

import com.pdp.persistence.dao.hibernate.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {
}
