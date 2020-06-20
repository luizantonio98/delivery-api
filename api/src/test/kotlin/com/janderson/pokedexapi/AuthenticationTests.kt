package com.janderson.pokedexapi

import org.hamcrest.Matchers.`is`
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
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
                .andExpect(jsonPath("$.name", `is`("Loja de construções do João")))
                .andExpect(jsonPath("$.password").doesNotExist())
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
//
//    @Test
//    fun findOne() {
//        mockMvc.perform(get("/items/1"))
//                .andExpect(status().isOk)
//                .andExpect(jsonPath("id", equalTo(1)))
//                .andExpect(jsonPath("name", `is`("Chave de fenda")))
//    }
//
//    @Test
//    fun update() {
//        val json = JSONObject(mutableMapOf(
//                "name" to "Novo nome",
//                "group" to mutableMapOf<String, Any>("id" to 1)
//        )).toString()
//        mockMvc.perform(put("/items/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andExpect(status().isOk)
//                .andExpect(jsonPath("$.name", `is`("Novo nome")))
//                .andExpect(jsonPath("$.group.id", `is`(1)))
//    }
//
//    @Test
//    fun deleteItem() {
//        mockMvc.perform(delete("/items/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk)
//    }
}
