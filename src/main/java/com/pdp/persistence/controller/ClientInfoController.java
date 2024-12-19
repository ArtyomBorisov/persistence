package com.pdp.persistence.controller;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.common.Sorting;
import com.pdp.persistence.dto.ClientInfoDto;
import com.pdp.persistence.service.ClientInfoService;
import com.pdp.persistence.validator.ClientInfoParamValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/client-infos")
@Slf4j
@RequiredArgsConstructor
public class ClientInfoController {

    private final ClientInfoService clientInfoService;
    private final ClientInfoParamValidator clientInfoParamValidator;

    @GetMapping
    public List<ClientInfoDto> getClientInfos(@RequestParam(value = "id", required = false) List<UUID> ids,
                                              @RequestParam(value = "sortingByName", required = false) Sorting sortingByName,
                                              @RequestParam(value = "name", required = false) String name,
                                              @RequestParam(name = "framework") Framework framework) {
        log.info("Получение информации о клиентах по параметрам: id {}, sortingByName {}, name {}", ids, sortingByName, name);
        clientInfoParamValidator.validateRequestParams(ids, sortingByName, name);
        if (ids != null) {
            return clientInfoService.findByIds(ids, framework);
        } else if (sortingByName != null) {
            return clientInfoService.findSortingByName(sortingByName, framework);
        } else {
            return clientInfoService.findWithNameLike(name, framework);
        }
    }
}
