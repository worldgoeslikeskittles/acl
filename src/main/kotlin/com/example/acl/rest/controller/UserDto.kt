package com.example.acl.rest.controller

import com.example.acl.domain.Role

/**
 * DTO for {@link com.example.acl.domain.User}
 */
data class UserDto(
    val workPlaceId: Long? = null,
    val userRoleRoles: MutableSet<Role>,
    val userCredentialsLogin: String? = null,
    val userCredentialsPassword: String? = null
)