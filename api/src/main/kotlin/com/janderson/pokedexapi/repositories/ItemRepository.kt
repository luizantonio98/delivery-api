package com.janderson.pokedexapi.repositories

import com.janderson.pokedexapi.models.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<Item?, Long>