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
class ItemControllerTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun listAllItems() {
        mockMvc.perform(get("/items"))
                .andExpect {
                    status().isOk
                    jsonPath("$.content[0].id", equalTo(1))
                    jsonPath("$.content[0].name", equalTo("Chave de fenda"))
                    jsonPath("$.content[0].group.id", equalTo(1))
                    jsonPath("$.content[0].group.name", equalTo("Ferramentas"))
                }
    }

    @Test
    fun findOne() {
        mockMvc.perform(get("/items/1"))
                .andExpect {
                    status().isOk
                    jsonPath("id", equalTo(1))
                    jsonPath("name", equalTo("Chave de fenda"))
                }
    }
}
