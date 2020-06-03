package com.janderson.pokedexapi.controllers

import com.janderson.pokedexapi.models.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController {
    val users : MutableList<User> = mutableListOf()

    @GetMapping
    fun home(): ResponseEntity<Any> {
        return ResponseEntity.ok(users)
    }

    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        users.add(user)
        return ResponseEntity.ok(user)
    }
}