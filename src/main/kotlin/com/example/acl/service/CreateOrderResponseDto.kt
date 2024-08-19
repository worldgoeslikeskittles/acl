package com.example.acl.service

/**
 * DTO for {@link com.example.acl.domain.Order}
 */
data class CreateOrderResponseDto(val id: Long? = null, val customerId: Long? = null) {
    private constructor() : this(null)
}