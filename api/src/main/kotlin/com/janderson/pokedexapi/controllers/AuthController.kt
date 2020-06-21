package com.janderson.pokedexapi.controllers

import com.janderson.pokedexapi.models.LoginAttempt
import com.janderson.pokedexapi.services.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
class AuthController {
    @Autowired
    lateinit var authService: AuthService

    /* Returns JWT */
    @PostMapping("/stores/login")
    fun get(@RequestBody @Valid loginAttempt: LoginAttempt): String {
        return authService.authenticateStore(loginAttempt)
    }
}