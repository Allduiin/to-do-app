package com.learn.todolist.service

import com.learn.todolist.domain.User
import com.learn.todolist.dto.UserDto
import com.learn.todolist.exception.UserRegistrationException
import com.learn.todolist.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(userDto: UserDto): User {
        if (userRepository.findByUsername(userDto.username).isPresent) {
            throw UserRegistrationException("User with same username already exists")
        }
        val user = User(
            username = userDto.username,
            password = passwordEncoder.encode(userDto.password)
        )
        return userRepository.save(user)
    }

    fun findByUserName(username: String): User? {
        TODO()
    }

    fun deleteUserById(id: Long): User {
        TODO()
    }

    fun getUserById(id: Long): User {
        TODO()
    }
}