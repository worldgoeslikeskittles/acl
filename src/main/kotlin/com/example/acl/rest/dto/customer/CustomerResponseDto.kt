package com.example.acl.rest.dto.customer

import com.example.acl.domain.Role

/**
 * DTO for {@link com.example.acl.domain.Customer}
 */
data class CustomerResponseDto(
    val id: Long? = null,
    val userRoles: MutableSet<Role>?,
    val userName: String? = null
)