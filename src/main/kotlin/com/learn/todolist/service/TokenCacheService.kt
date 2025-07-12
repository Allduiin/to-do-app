package com.learn.todolist.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class TokenCacheService(
    private val redisTemplate: RedisTemplate<String, String>
) {
    private companion object {
        const val TOKEN_PREFIX = "auth:token:"
    }

    /**
     * Сохраняет токен, связанный с username, с временем жизни ttl
     */
    fun storeToken(token: String, username: String, ttl: Duration = Duration.ofHours(1)) {
        val key = "$TOKEN_PREFIX$token"
        redisTemplate.opsForValue().set(key, username, ttl)
    }

    /**
     * Получает username по токену или null, если токен не найден или истёк
     */
    fun retrieveUsername(token: String): String? {
        val key = "$TOKEN_PREFIX$token"
        return redisTemplate.opsForValue().get(key)
    }

    /**
     * Продлевает время жизни существующего токена
     */
    fun extendToken(token: String, ttl: Duration = Duration.ofHours(1)) {
        val key = "$TOKEN_PREFIX$token"
        if (redisTemplate.hasKey(key)) {
            redisTemplate.expire(key, ttl)
        }
    }
}