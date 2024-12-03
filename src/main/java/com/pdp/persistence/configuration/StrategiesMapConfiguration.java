package com.pdp.persistence.configuration;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.strategy.AccountStrategy;
import com.pdp.persistence.strategy.ClientInfoStrategy;
import com.pdp.persistence.strategy.ClientStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class StrategiesMapConfiguration {

    public static final String MORE_THAN_ONE_STRATEGY = "Обнаружено более одной стратегии %s с типом %s";

    @Bean
    public Map<Framework, AccountStrategy> accountStrategyMap(List<AccountStrategy> accountStrategies) {
        return accountStrategies.stream()
                .collect(Collectors.toMap(
                        AccountStrategy::getFramework,
                        Function.identity(),
                        (strategy1, strategy2) -> {
                            throw new IllegalStateException(String.format(MORE_THAN_ONE_STRATEGY, strategy1.getClass(), strategy1.getFramework()));
                        })
                );
    }

    @Bean
    public Map<Framework, ClientInfoStrategy> clientInfoStrategyMap(List<ClientInfoStrategy> clientInfoStrategies) {
        return clientInfoStrategies.stream()
                .collect(Collectors.toMap(
                        ClientInfoStrategy::getFramework,
                        Function.identity(),
                        (strategy1, strategy2) -> {
                            throw new IllegalStateException(String.format(MORE_THAN_ONE_STRATEGY, strategy1.getClass(), strategy1.getFramework()));
                        })
                );
    }

    @Bean
    public Map<Framework, ClientStrategy> clientStrategyMap(List<ClientStrategy> clientStrategies) {
        return clientStrategies.stream()
                .collect(Collectors.toMap(
                        ClientStrategy::getFramework,
                        Function.identity(),
                        (strategy1, strategy2) -> {
                            throw new IllegalStateException(String.format(MORE_THAN_ONE_STRATEGY, strategy1.getClass(), strategy1.getFramework()));
                        })
                );
    }
}
