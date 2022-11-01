package org.top.jsonapiservicesolvation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.top.jsonapiservicesolvation.logic.CosineTheorem;
import org.top.jsonapiservicesolvation.logic.ICosineTheorem;

// класс-конфиг для DI
@Configuration
public class AppConfiguration {
    // бин для решения
    @Bean
    ICosineTheorem solution() {
        return new CosineTheorem();
    }
}

