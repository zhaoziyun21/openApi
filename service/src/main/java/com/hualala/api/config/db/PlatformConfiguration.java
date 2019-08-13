package com.hualala.api.config.db;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author : zhaoziyun
 * @Date : 2018/11/19
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "platformdatasource")
public class PlatformConfiguration {
    private String driverClassName;

    private String url;

    private String username;

    private String password;

    private int initialSize;

    private int maxActive;

    private int minIdle;

    private String validationQuery;
    private static final Logger LOGGER = LoggerFactory.getLogger(PlatformConfiguration.class);



    @Bean(name = "platform")
    public DataSource platformDataSource() {
        return DataSourceConfigSupport.getDataSource(
                driverClassName,
                url,
                username,
                password,
                initialSize,
                minIdle,
                maxActive,
                validationQuery);
    }

}
