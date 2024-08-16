package com.example.acl.rest.controller;

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * Test class for the {@link com.example.acl.rest.controller.CustomerRestController}
 */
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class CustomerRestControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {

    }

    @Test
    @Throws(Exception::class)
    fun registerByUser() {
        val customerRegistrationDto = """
    {
        "userCredentialsLogin": "someLogin",
        "userCredentialsPassword": "somePassword",
        "name": "Some Name"
    }"""

        mockMvc.perform(
            post("/rest/customers")
                .with(SecurityMockMvcRequestPostProcessors.csrf())
                .content(customerRegistrationDto)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andDo(print())
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun getOne() {
        mockMvc.perform(
            get("/rest/customers/{0}", "102")
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        )
            .andExpect(status().isOk())
            .andDo(print())
    }
}
