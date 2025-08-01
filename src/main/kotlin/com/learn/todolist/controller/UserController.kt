package com.learn.todolist.controller

import com.learn.todolist.dto.UserDto
import com.learn.todolist.mapper.toUserDto
import com.learn.todolist.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping
    fun create(@RequestBody user: UserDto) = UserDto(userService.register(user))

    @GetMapping
    fun findAll(@RequestParam userName: String): UserDto? = userService.findByUserName(userName)?.toUserDto()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): UserDto = userService.getUserById(id).toUserDto()
}