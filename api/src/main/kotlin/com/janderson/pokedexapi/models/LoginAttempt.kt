package com.janderson.pokedexapi.models

import com.sun.istack.NotNull
import javax.validation.constraints.NotEmpty

data class LoginAttempt (
    @NotNull
    @NotEmpty
    val email : String,

    @NotNull
    @NotEmpty
    val password: String
)
