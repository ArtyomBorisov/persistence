package com.pdp.persistence.validator;

import com.pdp.persistence.common.Sorting;
import com.pdp.persistence.exception.BadRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class ClientInfoParamValidator {

    public void validateRequestParams(List<UUID> ids, Sorting sortingByName, String name) {
        final var params = Stream.of(ids, sortingByName, name)
                .filter(Objects::nonNull)
                .count();
        if (params != 1) {
            throw new BadRequest("Должен быть передан строго один из параметров: ids, sortingByName, name");
        }
    }
}
