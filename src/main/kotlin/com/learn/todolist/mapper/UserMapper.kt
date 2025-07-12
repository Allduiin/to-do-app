package com.learn.todolist.mapper

import com.learn.todolist.domain.User
import com.learn.todolist.dto.UserDto

fun User.toUserDto() = UserDto(this)