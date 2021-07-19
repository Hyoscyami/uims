package com.xushifei.uims.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * redis工具类
 * </p>
 *
 * @author xushifei
 * @date 2021/4/8
 */
@Slf4j
@Component
public class RedisUtils {
    private final RedissonClient redissonClient;

    public RedisUtils(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    public void set(String key, Object value, long timeout, TimeUnit timeUnit) {
        RBucket<Object> bucket = this.redissonClient.getBucket(key);
        bucket.set(value, timeout, timeUnit);
    }

    public void set(String key, Object value) {
        RBucket<Object> bucket = this.redissonClient.getBucket(key);
        bucket.set(value);
    }

    public <T> T get(String key, Class<T> clazz) {
        RBucket<T> bucket = this.redissonClient.getBucket(key);
        return bucket.get();
    }

    public boolean delete(String key) {
        RBucket<Object> bucket = this.redissonClient.getBucket(key);
        return bucket.delete();
    }

    public void setAsync(String key, Object value, long timeout, TimeUnit timeUnit) {
        RBucket<Object> bucket = this.redissonClient.getBucket(key);
        bucket.setAsync(value, timeout, timeUnit);
    }

    public boolean trySet(String key, Object value, long timeout, TimeUnit timeUnit) {
        RBucket<Object> bucket = this.redissonClient.getBucket(key);
        return bucket.trySet(value, timeout, timeUnit);
    }

    public long incrementAtomicLong(String key) {
        RAtomicLong atomicLong = this.redissonClient.getAtomicLong(key);
        return atomicLong.incrementAndGet();
    }

    public boolean expireAtomicLong(String key, long timeout, TimeUnit timeUnit) {
        RAtomicLong atomicLong = this.redissonClient.getAtomicLong(key);
        return atomicLong.expire(timeout, timeUnit);
    }

    public RFuture<Boolean> expireAsyncAtomicLong(String key, long timeout, TimeUnit timeUnit) {
        RAtomicLong atomicLong = this.redissonClient.getAtomicLong(key);
        return atomicLong.expireAsync(timeout, timeUnit);
    }

    public long getAtomicLong(String key) {
        RAtomicLong atomicLong = this.redissonClient.getAtomicLong(key);
        return atomicLong.get();
    }

    public RLock lock(String lockKey) {
        RLock lock = this.redissonClient.getLock(lockKey);
        lock.lock();
        return lock;
    }

    public RLock lock(String lockKey, long leaseTime) {
        RLock lock = this.redissonClient.getLock(lockKey);
        lock.lock(leaseTime, TimeUnit.SECONDS);
        return lock;
    }

    public RLock lock(String lockKey, TimeUnit unit, long timeout) {
        RLock lock = this.redissonClient.getLock(lockKey);
        lock.lock(timeout, unit);
        return lock;
    }

    public boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime) {
        RLock lock = this.redissonClient.getLock(lockKey);

        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException var9) {
            return false;
        }
    }

    public void unlock(String lockKey) {
        RLock lock = this.redissonClient.getLock(lockKey);
        lock.unlock();
    }

    public void unlock(RLock lock) {
        lock.unlock();
    }
}