package com.janderson.pokedexapi.controllers

import com.janderson.pokedexapi.exceptions.EntityNotFoundException
import com.janderson.pokedexapi.models.Item
import com.janderson.pokedexapi.models.Store
import com.janderson.pokedexapi.repositories.StoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class AuthController {

    @Autowired
    lateinit var storeRepository: StoreRepository

    @PostMapping("/stores/login")
    fun get(@RequestBody store: Store): Store {
        return try {
            storeRepository.findByEmail(store.email!!)
        } catch (e: Exception) {
            throw EntityNotFoundException()
        }
    }
}