package com.learn.todolist.controller

import com.learn.todolist.service.AuthenticationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Base64

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authenticationService: AuthenticationService
) {
    data class LoginRequest(val username: String, val password: String)
    data class LoginResponse(val token: String)

    @PostMapping("/login")
    fun login(@RequestBody req: LoginRequest): ResponseEntity<LoginResponse> {
        val creds = "${req.username}:${req.password}"
        val header = "Basic " + Base64.getEncoder().encodeToString(creds.toByteArray())
        val token = authenticationService.login(header)
        return ResponseEntity.ok(LoginResponse(token))
    }
}