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
 * Test class for the {@link com.example.acl.rest.controller.DepartmentController}
 */
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class DepartmentControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {

    }

    @Test
    @Throws(Exception::class)
    //@Sql(scripts = ["classpath:sql/data.sql"])
    fun create() {
        val dto = """
    {
        "managerId": 3,
        "name": "my_deaprtment"
    }"""

        mockMvc.perform(
            post("/rest/departments")
                .with(SecurityMockMvcRequestPostProcessors.csrf())
                //.with(SecurityMockMvcRequestPostProcessors.user("user"))
                .content(dto)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andDo(print())
    }
}
