package com.example.acl.rest.controller;

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * Test class for the {@link com.example.acl.rest.controller.OrderController}
 */
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class OrderControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {

    }

    @Test
    @Throws(Exception::class)
    @Sql(scripts = ["classpath:sql/customer_for_tests.sql"])
    fun create() {
        val dto = """
    {
        "customerId": 1
    }"""

        mockMvc.perform(
            post("/rest/orders")
                .with(SecurityMockMvcRequestPostProcessors.csrf())
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andDo(print())
    }

    @Test
    @Throws(Exception::class)
    fun getOne() {
        mockMvc.perform(
            get("/rest/orders/{0}", "2")
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        )
            .andExpect(status().isOk())
            .andDo(print())
    }
}
