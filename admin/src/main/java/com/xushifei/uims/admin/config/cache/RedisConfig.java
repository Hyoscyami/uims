package com.xushifei.uims.admin.config.cache;

import com.xushifei.uims.admin.enums.RedisEnum;
import com.xushifei.uims.common.enums.ApiCodeEnum;
import com.xushifei.uims.common.exception.BusinessException;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * redis相关配置
 * </p>
 *
 * @author xushifei
 * @date 2021/4/8
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedissonClient redissonClient(RedisProperties properties) {
        //单机
        if (RedisEnum.SINGLE_MODE.eq(properties.getMode())) {
            return this.getSingleClient(properties);
        }
        if (RedisEnum.SENTINEL_MODE.eq(properties.getMode())) {
            return this.getSentinelClient(properties);
        }
        if (RedisEnum.CLUSTER_MODE.eq(properties.getMode())) {
            return this.getClusterClient(properties);
        }
        throw new BusinessException(ApiCodeEnum.SYSTEM_ERROR.getCode(), "暂不支持" + properties.getMode() + "redis模式");
    }

    /**
     * 获取单机RedissonClient
     *
     * @param properties
     * @return
     */
    private RedissonClient getSingleClient(RedisProperties properties) {
        Config config = new Config();
        config.setCodec(new JsonJacksonCodec());
        SingleServerConfig singleServerConfig = config.useSingleServer();
        BeanUtils.copyProperties(properties, singleServerConfig);
        return Redisson.create(config);
    }

    /**
     * 获取哨兵RedissonClient
     *
     * @param properties
     * @return
     */
    private RedissonClient getSentinelClient(RedisProperties properties) {
        Config config = new Config();
        config.setCodec(new JsonJacksonCodec());
        SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
        BeanUtils.copyProperties(properties, sentinelServersConfig);
        return Redisson.create(config);
    }

    /**
     * 获取集群RedissonClient
     * @param properties
     * @return
     */
    private RedissonClient getClusterClient(RedisProperties properties){
        Config config = new Config();
        config.setCodec(new JsonJacksonCodec());
        ClusterServersConfig clusterServersConfig = config.useClusterServers();
        BeanUtils.copyProperties(properties, clusterServersConfig);
        return Redisson.create(config);
    }
}