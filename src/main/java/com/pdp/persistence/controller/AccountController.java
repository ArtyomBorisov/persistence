package com.pdp.persistence.controller;

import com.pdp.persistence.common.ORM;
import com.pdp.persistence.hibernate.repository.AccountRepository;
import com.pdp.persistence.mybatis.mapper.AccountDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String getAll(@RequestParam ORM orm) {
        List<?> accounts = switch (orm) {
            case HIBERNATE -> accountRepository.findAll();
            case MYBATIS -> accountDataMapper.findAll();
        };
        log.info("{}", accounts.size());
        return String.valueOf(accounts.size());
    }
}
