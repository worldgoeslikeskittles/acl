package com.example.acl.service

import com.example.acl.domain.Role
import com.example.acl.repository.UserRepository
import com.example.acl.rest.dto.customer.CustomerRegistrationDto
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class UserServiceTest {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userService: UserService


    @Test
    @Transactional
    fun createUserForCustomer() {
        val customerRegistrationDto = CustomerRegistrationDto(
            name = "some Customer Name",
            userCredentialsLogin = "some User Login",
            userCredentialsPassword = "some User Password"
        )
        val resultUser = userService.createUserForCustomer(customerRegistrationDto)

        // релоадим пользователя потому что хибернейт персистит сущность, но возвращает обновленный айдишником исходный обюект
        val reloadedUser = userRepository.findById(resultUser.id!!).orElseThrow()
        assertEquals(customerRegistrationDto.name, reloadedUser.name)
        assertEquals(customerRegistrationDto.userCredentialsLogin, reloadedUser.userCredentials!!.login)
        assertNotNull(reloadedUser.userRoles.firstOrNull { it.role == Role.CUSTOMER })
    }
}