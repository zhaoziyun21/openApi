package com.hualala.qa.k8s.op.config;

import lombok.Data;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by ben on 5/23/17.
 */
public class RedisUtils {

    public static JedisConnectionFactory getJedisFactory(String host, Integer port, Integer db, Pool pool) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(pool.getMaxIdle());
        config.setMinIdle(pool.getMinIdle());
        config.setMaxTotal(pool.getMaxActive());
        config.setMaxWaitMillis(pool.getMaxWait());
        config.setTestOnBorrow(true);

        JedisConnectionFactory factory = new JedisConnectionFactory(config);
        factory.setHostName(host);
        factory.setPort(port);
        factory.setDatabase(db);

        return factory;
    }

    @Data
    public static class Pool {
        private Integer maxActive;
        private Integer writeTimeout;
        private Integer readTimeout;
        private Integer maxIdle;
        private Integer minIdle;
        private Integer maxWait;
    }

}
