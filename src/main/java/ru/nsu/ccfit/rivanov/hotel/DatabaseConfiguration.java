package ru.nsu.ccfit.rivanov.hotel;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@EnableJpaRepositories
@Configuration
public class DatabaseConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "dbsource")
    DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        return builder.build();
    }

}
