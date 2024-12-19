package com.pdp.persistence.controller;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dto.ClientDto;
import com.pdp.persistence.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/clients")
@Slf4j
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{id}")
    public ClientDto getClientById(@PathVariable(name = "id") UUID id,
                                   @RequestParam(name = "framework") Framework framework) {
        log.info("Получение клиента по id {}", id);
        return clientService.findById(id, framework);
    }

    @GetMapping
    public List<ClientDto> getAllClients(@RequestParam(name = "framework") Framework framework) {
        log.info("Получение всех клиентов");
        return clientService.findAll(framework);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveClient(@RequestBody ClientDto clientDto,
                           @RequestParam(name = "framework") Framework framework) {
        log.info("Сохранение клиента с id {}", clientDto.id());
        clientService.save(clientDto, framework);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable(name = "id") UUID id,
                                 @RequestParam(name = "framework") Framework framework) {
        log.info("Удаление клиента по id {}", id);
        clientService.deleteById(id, framework);
    }

    @PatchMapping("/{id}")
    public void updateClient(@PathVariable(name = "id") UUID id,
                             @RequestBody ClientDto clientDto,
                             @RequestParam(name = "framework") Framework framework) {
        log.info("Обновление клиента: {}", clientDto);
        clientService.update(id, clientDto, framework);
    }
}
