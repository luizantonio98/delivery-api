package com.janderson.pokedexapi.models

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(name = "name")
        val name: String,
        @Column (name = "email")
        val email: String,
        @Column (name = "password")
        val password: String
)