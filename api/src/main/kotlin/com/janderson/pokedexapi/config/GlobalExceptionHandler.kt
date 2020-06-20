package com.janderson.pokedexapi.config

import com.janderson.pokedexapi.exceptions.EntityNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [EntityNotFoundException::class])
    fun handleConstraintViolation(
            ex: EntityNotFoundException, request: WebRequest?): ResponseEntity<Any> {
        return ResponseEntity.notFound().build()
    }
}