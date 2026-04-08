package com.symplifica.clients_message.config;


import javax.sql.DataSource;

import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.sql.postgres.PostgresStorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobRunrConfig {

    @Bean
    StorageProvider storageProvider(DataSource dataSource) {
        return new PostgresStorageProvider(dataSource);
    }

}