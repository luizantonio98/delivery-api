package com.janderson.pokedexapi

import org.json.JSONObject
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = ["classpath:test.properties"])
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AuthenticationTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun login() {
        val json = JSONObject(mutableMapOf(
                "email" to "joao@gmail.com",
                "password" to "123456"
        )).toString()
        mockMvc.perform(post("/stores/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk)
    }

    @Test
    fun loginWithFakeEmail() {
        val json = JSONObject(mutableMapOf(
                "email" to "fake@email.com",
                "password" to "123456"
        )).toString()
        mockMvc.perform(post("/stores/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isNotFound)
    }

    @Test
    fun loginWithEmptyEmail() {
        val json = JSONObject(mutableMapOf(
                "email" to "",
                "password" to "123456"
        )).toString()
        mockMvc.perform(post("/stores/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isNotFound)
    }

    @Test
    fun loginWithNullEmail() {
        val json = JSONObject(mutableMapOf(
                "password" to "123456"
        )).toString()
        mockMvc.perform(post("/stores/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest)
    }
}
