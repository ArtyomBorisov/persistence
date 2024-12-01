package com.pdp.persistence.configuration;

import com.pdp.persistence.common.Framework;
import com.pdp.persistence.strategy.AccountStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class StrategiesMapConfiguration {

    @Bean
    public Map<Framework, AccountStrategy> accountStrategyMap(List<AccountStrategy> accountStrategies) {
        return accountStrategies.stream().collect(Collectors.toMap(
                AccountStrategy::getFramework,
                Function.identity(),
                (strategy1, strategy2) -> {
                    throw new IllegalStateException("Обнаружено более одной стратегии для счетов, тип: " + strategy1.getFramework());
                }
        ));
    }
}
