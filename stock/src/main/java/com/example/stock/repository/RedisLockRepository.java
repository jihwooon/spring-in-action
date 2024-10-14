package com.example.stock.repository;

import java.time.Duration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisLockRepository {

    private RedisTemplate<String, String> template;

    public RedisLockRepository(RedisTemplate<String, String> template) {
        this.template = template;
    }

    public Boolean lock(Long key) {
        return template.opsForValue()
            .setIfAbsent(generateKey(key), "lock", Duration.ofMillis(3_000));
    }

    public Boolean unLock(Long key) {
        return template.delete(generateKey(key));
    }

    public String generateKey(Long key) {
        return key.toString();
    }
}
