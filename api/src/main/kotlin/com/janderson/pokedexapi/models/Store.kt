package com.janderson.pokedexapi.models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "stores")
data class Store(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,

        @Column(name = "name")
        val name: String?,

        @Column(name = "color")
        val color: String?,

        @Column(name = "email")
        val email: String?,

        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @Column(name = "password")
        val password: String?
)
