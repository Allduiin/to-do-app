package com.learn.todolist.dto

import com.learn.todolist.domain.Role
import com.learn.todolist.domain.User

class UserDto(
    val username: String,
    val password: String? = null,
    val role: Role = Role.USER,
) {
    constructor(user: User) : this (username = user.username, role = user.role)
}