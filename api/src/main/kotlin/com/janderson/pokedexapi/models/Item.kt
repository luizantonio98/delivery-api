package com.janderson.pokedexapi.models

import javax.persistence.*

@Entity
@Table(name = "items")
data class Item(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(name = "name")
        var name: String,

        @ManyToOne
        @JoinColumn(name = "item_group_id")
        var group : ItemGroup
)
