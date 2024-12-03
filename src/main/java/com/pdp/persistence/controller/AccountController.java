package com.pdp.persistence.controller;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.dto.AccountDto;
import com.pdp.persistence.dto.BalanceDto;
import com.pdp.persistence.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/test")
    public String testGet() {
        return "success";
    }

    @GetMapping("/{id}")
    public AccountDto getAccountById(@PathVariable(name = "id") UUID id, @RequestParam(name = "framework") Framework framework) {
        log.info("Получение счета по id {}", id);
        return accountService.findById(id, framework);
    }

    @GetMapping
    public List<AccountDto> getAllAccounts(@RequestParam(name = "framework") Framework framework) {
        log.info("Получение всех счетов");
        return accountService.findAll(framework);
    }

    @GetMapping("/effectively")
    public List<AccountDto> getAllAccountsEffectively(@RequestParam(name = "framework") Framework framework) {
        log.info("Получение всех счетов \"эффективно\"");
        return accountService.findAllEffectively(framework);
    }
}
