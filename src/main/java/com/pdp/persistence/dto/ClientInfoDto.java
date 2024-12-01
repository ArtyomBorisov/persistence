package com.pdp.persistence.dto;

import java.util.UUID;

public record ClientInfoDto(UUID id,
                            String name,
                            String surname) {
}
