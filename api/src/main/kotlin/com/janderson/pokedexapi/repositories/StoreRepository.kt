package com.janderson.pokedexapi.repositories

import com.janderson.pokedexapi.models.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository : JpaRepository<Store?, Long>