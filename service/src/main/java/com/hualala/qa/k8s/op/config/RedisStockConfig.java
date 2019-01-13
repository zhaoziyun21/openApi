/**
 * Copyright (c) 2014 http://www.jieqianhua.com
 */
package com.hualala.qa.k8s.op.config;

import com.hualala.qa.k8s.op.client.redis.RedisClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;


@Data
@Configuration
@ConfigurationProperties(prefix = "redis-stock")
public class RedisStockConfig {

    private String host;

    private Integer port;

    private Integer db;

    private RedisUtils.Pool pool;

    @Bean(destroyMethod = "destroy", name = "redisConnectionFactory")
    public JedisConnectionFactory redisConnectionFactory() {
        return RedisUtils.getJedisFactory(host, port, db, pool);
    }

    @Bean(name = "redisStockClient")
    public RedisClient redisStockClient(JedisConnectionFactory redisConnectionFactory) {
        return new RedisClient(redisConnectionFactory);
    }
}
