package com.janderson.pokedexapi.controllers

import com.janderson.pokedexapi.models.Item
import com.janderson.pokedexapi.models.Store
import com.janderson.pokedexapi.repositories.ItemRepository
import com.janderson.pokedexapi.repositories.StoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/items")
class ItemController {

    @Autowired
    lateinit var itemRepository: ItemRepository

    @GetMapping
    fun list(pageable: Pageable): Page<Item?> {
        return itemRepository.findAll(pageable)
    }

    @GetMapping("{id}")
    fun get(pageable: Pageable, @PathVariable id: Long): Item? {
        return itemRepository.findById(id).orElse(null)
    }

}