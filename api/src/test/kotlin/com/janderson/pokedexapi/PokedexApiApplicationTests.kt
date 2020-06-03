package com.janderson.pokedexapi

import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = ["classpath:test.properties"])
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class PokedexApiApplicationTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun contextLoads() {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk)
    }

    @Test
    fun findOne() {
        mockMvc.perform(get("/stores/1"))
                .andExpect {
                    status().isOk
                    jsonPath("id", equalTo(1))
                    jsonPath("name", equalTo("Loja de construções do João"))
                    jsonPath("color", equalTo("FF0000"))
                }
    }
}
