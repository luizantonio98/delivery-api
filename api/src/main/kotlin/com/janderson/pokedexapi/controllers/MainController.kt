package com.janderson.pokedexapi.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @GetMapping("/")
    fun home(): ResponseEntity<Any> {
        return ResponseEntity.ok("Hello world")
    }

}