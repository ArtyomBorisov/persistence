package com.pdp.persistence.hibernate.repository;

import com.pdp.persistence.hibernate.entity.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, UUID> {
}
