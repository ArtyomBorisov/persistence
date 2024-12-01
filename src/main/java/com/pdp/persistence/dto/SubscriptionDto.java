package com.pdp.persistence.dto;

import java.util.UUID;

public record SubscriptionDto(UUID id,
                              String title,
                              String description) {
}
