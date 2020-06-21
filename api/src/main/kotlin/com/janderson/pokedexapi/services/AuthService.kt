package com.janderson.pokedexapi.services

import com.janderson.pokedexapi.config.JWTUtil
import com.janderson.pokedexapi.exceptions.BadCredentialsException
import com.janderson.pokedexapi.exceptions.EntityNotFoundException
import com.janderson.pokedexapi.models.LoginAttempt
import com.janderson.pokedexapi.repositories.StoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class AuthService {
    @Autowired
    private lateinit var storeRepository: StoreRepository

    @Autowired
    private lateinit var jwtUtil: JWTUtil


    /* Returns JWT as String */
    fun authenticateStore(loginAttempt: LoginAttempt): String {
        val store = try {
            storeRepository.findByEmail(loginAttempt.email)
        } catch (e: EmptyResultDataAccessException) {
            throw EntityNotFoundException()
        }
        if (loginAttempt.password != store.password) {
            throw BadCredentialsException();
        }
        return jwtUtil.generateToken(loginAttempt.email)
    }
}