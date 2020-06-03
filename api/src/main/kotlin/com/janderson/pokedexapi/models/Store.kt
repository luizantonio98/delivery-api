package com.janderson.pokedexapi.models

import javax.persistence.*

@Entity
@Table(name = "stores")
data class Store(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(name = "name")
        val name: String,

        @Column(name = "color")
        val color: String
)
