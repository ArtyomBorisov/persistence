package com.pdp.persistence.dto;

import java.util.UUID;

public record ClientDto(UUID id,
                        ClientInfoDto clientInfo,
                        String identificationNumber) {
}
