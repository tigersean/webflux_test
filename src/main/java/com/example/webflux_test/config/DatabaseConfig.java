package com.example.webflux_test.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;

import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
/**
 * @author HelloWood
 */
@Configuration
@EnableR2dbcRepositories
public class DatabaseConfig extends AbstractR2dbcConfiguration {

    @Value("${spring.datasource.name}")
    private String datasourceName;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @Bean("h2")
    @Override
    public ConnectionFactory connectionFactory() {
//        return new H2ConnectionFactory(H2ConnectionConfiguration.builder()
//                                                                .inMemory(datasourceName)
//                                                                .username(username)
//                                                                .password(password)
//                                                                .build());
//

      return ConnectionFactoryBuilder.withUrl(url).username(username).password(password).build();
    }

    @Bean
    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }

}
