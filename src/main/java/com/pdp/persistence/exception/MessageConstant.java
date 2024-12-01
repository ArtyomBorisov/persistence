package com.pdp.persistence.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MessageConstant {

    public static final String ACCOUNT_NOT_FOUND = "Не найден счет с id %s";
    public static final String CLIENT_NOT_FOUND = "Не найден клиент с id %s";
}
