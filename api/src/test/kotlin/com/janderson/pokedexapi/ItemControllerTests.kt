package com.janderson.pokedexapi

import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.equalTo
import org.json.JSONObject
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = ["classpath:test.properties"])
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ItemControllerTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun listAllItems() {
        mockMvc.perform(get("/items"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.content[0].name", `is`("Chave de fenda")))
                .andExpect(jsonPath("$.content[0].group.id", `is`(1)))
                .andExpect(jsonPath("$.content[0].group.name", `is`("Ferramentas")))
    }

    @Test
    fun findOne() {
        mockMvc.perform(get("/items/1"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("id", equalTo(1)))
                .andExpect(jsonPath("name", `is`("Chave de fenda")))
    }

    @Test
    fun update() {
        val json = JSONObject(mutableMapOf(
                "name" to "Novo nome",
                "group" to mutableMapOf<String, Any>("id" to 1)
        )).toString()
        mockMvc.perform(put("/items/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.name", `is`("Novo nome")))
                .andExpect(jsonPath("$.group.id", `is`(1)))
    }

    @Test
    fun deleteItem() {
        mockMvc.perform(delete("/items/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
    }
}
