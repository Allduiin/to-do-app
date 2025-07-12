package com.learn.todolist.service

import org.springframework.http.HttpHeaders
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.Base64
import java.util.UUID

@Service
class AuthenticationService(
    private val userService: UserService,
    private val tokenCache: TokenCacheService,
    private val passwordEncoder: PasswordEncoder
) {

    fun login(authHeader: String): String {
        // Извлечь и декодировать Basic credentials
        val credentials = authHeader.removePrefix("Basic ").trim()
        val decoded = String(Base64.getDecoder().decode(credentials))
        val (username, rawPassword) = decoded.split(":", limit = 2)

        // Проверить пользователя и пароль
        val user = userService.findByUserName(username)
            ?: throw UserLoginException("User not found")
        if (!passwordEncoder.matches(rawPassword, user.password)) {
            throw UserLoginException("Invalid credentials")
        }

        // Сгенерировать и сохранить токен
        val token = UUID.randomUUID().toString()
        tokenCache.storeToken(token, username)
        return token
    }

    fun checkAuthorization(headers: HttpHeaders) {
        if (headers.getFirst("AuthEnabled").toBoolean()) {
            val raw = headers.getFirst(HttpHeaders.AUTHORIZATION) ?: throw UnauthorizedException()
            val token = raw.removePrefix("Bearer ").trim()
            tokenCache.retrieveUsername(token) ?: throw UnauthorizedException()
            // Продлить токен
            tokenCache.extendToken(token)
        }
    }

    /**
     * Исключение при ошибках логина
     */
    class UserLoginException(message: String? = null) : RuntimeException(message)

    /**
     * Исключение при отсутствии/некорректном токене
     */
    class UnauthorizedException(message: String? = null) : RuntimeException(message)
}