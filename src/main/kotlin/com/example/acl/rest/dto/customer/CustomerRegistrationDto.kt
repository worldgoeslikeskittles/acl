package com.example.acl.rest.dto.customer

/**
 * DTO for {@link com.example.acl.domain.User}
 */
data class CustomerRegistrationDto(
    val userCredentialsLogin: String? = null,
    val userCredentialsPassword: String? = null,
    val name: String? = null
)