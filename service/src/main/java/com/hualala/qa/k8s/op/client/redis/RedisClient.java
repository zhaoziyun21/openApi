package com.hualala.qa.k8s.op.client.redis;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Created by BookThief on 2016/6/6.
 */
public class RedisClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisClient.class);

    private JedisConnectionFactory jedisConnectionFactory;

    public RedisClient(JedisConnectionFactory factory) {
        this.jedisConnectionFactory = factory;
        LOGGER.info("factory {} RedisClient initial...", factory.getHostName());
    }

    /**
     * @param key
     * @return
     * @see Jedis#exists(String)
     */
    public boolean exists(String key) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().exists(key);
        } finally {
            returnResource(jedisConnection);
        }
    }

    /**
     * @param key
     * @return
     */
    public Long incr(String key) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().incr(key);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public Long expire(String key, int seconds) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().expire(key, seconds);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public Long expireAt(String key, long unixTime) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            Long result = jedisConnection.getNativeConnection().expireAt(key, unixTime);
            return result;
        } finally {
            returnResource(jedisConnection);
        }
    }

    public String set(String key, String value) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().set(key, value);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public String setEx(String key, int seconds, Object value) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            String valueJson;
            if (value instanceof String) {
                valueJson = value.toString();
            } else {
                valueJson = JSON.toJSONString(value);
            }

            return jedisConnection.getNativeConnection().setex(key, seconds, valueJson);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public String get(String key) {
        Object result = null;

        if (exists(key)) {
            checkKey(key);
            JedisConnection jedisConnection = null;
            try {
                jedisConnection = getJedisConnection();
                result = jedisConnection.getNativeConnection().get(key);
            } finally {
                returnResource(jedisConnection);
            }
        }

        return null != result ? result.toString() : StringUtils.EMPTY;
    }

    public Long del(String key) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().del(key);
        } finally {
            returnResource(jedisConnection);
        }
    }

    /****
     * map
     */

    public Long hset(String key, String field, String value) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            Long result = jedisConnection.getNativeConnection().hset(key, field, value);
            return result;
        } finally {
            returnResource(jedisConnection);
        }
    }

    public Long hincrby(String key, String field, long value) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            Long result = jedisConnection.getNativeConnection().hincrBy(key, field, value);
            return result;
        } finally {
            returnResource(jedisConnection);
        }
    }

    public Long hdel(String key, String... fields) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            Long result = jedisConnection.getNativeConnection().hdel(key, fields);
            return result;
        } finally {
            returnResource(jedisConnection);
        }
    }

    public String hget(String key, String field) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().hget(key, field);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public <T> T hget(String key, String field, Class<T> tClass) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            String value = jedisConnection.getNativeConnection().hget(key, field);
            return JSON.parseObject(value, tClass);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public Map<String, String> hgetAll(String key) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            Map<String, String> value = jedisConnection.getNativeConnection().hgetAll(key);
            return value;
        } finally {
            returnResource(jedisConnection);
        }
    }

    public <T> Map<String, T> hgetAll(String key, Class<T> tClass) {
        Map<String, T> ret = new HashMap<String, T>();
        Map<String, String> all = hgetAll(key);
        for (String k : all.keySet()) {
            String v = all.get(k);
            ret.put(k, JSON.parseObject(v, tClass));
        }
        return ret;
    }

    public List<String> hgetAllValue(String key) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            List<String> value = jedisConnection.getNativeConnection().hvals(key);
            return value;
        } finally {
            returnResource(jedisConnection);
        }
    }

    public <T> List<T> hgetAllValue(String key, Class<T> tClass) {
        List<T> ret = new ArrayList<T>();
        List<String> values = hgetAllValue(key);
        for (String v : values) {
            ret.add(JSON.parseObject(v, tClass));
        }
        return ret;
    }

    public List<String> hmget(String key, List<String> fields) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            List<String> value = jedisConnection.getNativeConnection().hmget(key, fields.toArray(new String[fields.size()]));
            return value;
        } finally {
            returnResource(jedisConnection);
        }
    }

    public String hmset(String key, Map<String, String> fieldMap) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().hmset(key, fieldMap);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public Long zrank(String key, String member) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().zrank(key, member);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public Long rpush(String key, String value) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().rpush(key, value);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public Long setnx(String key, String value) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().setnx(key, value);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public String getSet(String key, String value) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().getSet(key, value);
        } finally {
            returnResource(jedisConnection);
        }
    }

    private JedisConnection getJedisConnection() {
        return (JedisConnection) jedisConnectionFactory.getConnection();
    }

    /****
     * @param key
     */
    private void checkKey(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Cache key is null or not a length of 0.");
        }
    }

    /**
     * 返还Jedis到连接池
     *
     * @param jedisConnection
     */
    private void returnResource(JedisConnection jedisConnection) {
        if (jedisConnection != null) {
            jedisConnection.close();
        }
    }

    /**
     * SET方法第三个参数
     * NX：key不存在则执行SET
     * XX：key存在则执行SET
     */
    private static final String SET_IF_NOT_EXIST = "NX";

    /**
     * SET方法第四个参数：控制第五个参数的时间单位
     * EX：秒
     * PX：毫秒
     */
    private static final String SET_WITH_EXPIRE_TIME = "EX";

    /**
     * 设置分布式锁
     *
     * @param key   需要上锁的key。
     * @param value 上锁的主人，可以为IP、UUID、HOSTNAME等。
     * @param time  锁的过期时间
     * @return String "OK"：获取锁成功；"NIL"：获取锁失败。
     */
    public String lock(String key, String value, long time) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().set(key, value, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, time);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public boolean lockSuccess(String lockInfo) {
        return !StringUtils.isEmpty(lockInfo) && "ok".equalsIgnoreCase(lockInfo);
    }

    /**
     * 释放分布式锁
     */
    public Object unlock(String lockKey, String requestId) {
        checkKey(lockKey);
        JedisConnection jedisConnection = null;
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        } finally {
            returnResource(jedisConnection);
        }
    }

    /**
     * set类型是否存在某个元素
     * @param key
     * @param member
     * @return
     */
    public boolean sismember(String key, String member){
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().sismember(key, member);
        } finally {
            returnResource(jedisConnection);
        }
    }


    public Long sadd(String key, String value) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().sadd(key, value);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public Set smembers(String key) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().smembers(key);
        } finally {
            returnResource(jedisConnection);
        }
    }

    public Long srem(String key , String value) {
        checkKey(key);
        JedisConnection jedisConnection = null;
        try {
            jedisConnection = getJedisConnection();
            return jedisConnection.getNativeConnection().srem(key,value);
        } finally {
            returnResource(jedisConnection);
        }
    }
}
