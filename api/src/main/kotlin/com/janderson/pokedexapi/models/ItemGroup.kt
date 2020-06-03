package com.janderson.pokedexapi.models

import javax.persistence.*

@Entity
@Table(name = "item_groups")
data class ItemGroup(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(name = "name")
        val name: String
)
