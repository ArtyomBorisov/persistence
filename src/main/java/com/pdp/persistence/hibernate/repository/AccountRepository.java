package com.pdp.persistence.hibernate.repository;

import com.pdp.persistence.hibernate.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {
}
