package com.janderson.pokedexapi.controllers

import com.janderson.pokedexapi.models.Item
import com.janderson.pokedexapi.models.Store
import com.janderson.pokedexapi.repositories.ItemRepository
import com.janderson.pokedexapi.repositories.StoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


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
    fun get(pageable: Pageable, @PathVariable id: Long): ResponseEntity<Item?> {
        return itemRepository.findById(id).map { i ->
            ResponseEntity.ok(i!!)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun create(@RequestBody item: Item): Item? {
        return itemRepository.save(item)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id :Long,
               @RequestBody item: Item): ResponseEntity<Item?> {
        return itemRepository.findById(id).map { i ->
            i!!.group = item.group
            i.name = item.name
            ResponseEntity.ok(i)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id :Long): ResponseEntity<Item?> {
        return itemRepository.findById(id).map { i ->
            ResponseEntity.ok(i!!)
        }.orElse(ResponseEntity.notFound().build())
    }
}