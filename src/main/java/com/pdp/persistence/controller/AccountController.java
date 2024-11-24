package com.pdp.persistence.controller;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.hibernate.repository.AccountRepository;
import com.pdp.persistence.mybatis.mapper.AccountDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountRepository accountRepository;
    private final AccountDataMapper accountDataMapper;

    @GetMapping("/test")
    public String testGet() {
        return "success";
    }

    @GetMapping
    public List<?> getAll(@RequestParam Framework framework) {
        List<?> accounts = switch (framework) {
            case HIBERNATE -> accountRepository.findAll();
            case MYBATIS -> Collections.emptyList();
        };
        log.info("size: {}", accounts.size());
        return accounts;
    }
}
