package com.janderson.pokedexapi.controllers

import com.janderson.pokedexapi.models.Store
import com.janderson.pokedexapi.repositories.StoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/stores")
class StoreController {

    @Autowired
    lateinit var storeRepository: StoreRepository

    @GetMapping
    fun list(pageable: Pageable): Page<Store?> {
        return storeRepository.findAll(pageable)
    }

    @GetMapping("{id}")
    fun get(pageable: Pageable, @PathVariable id: Long): Store? {
        return storeRepository.findById(id).orElse(null)
    }

}