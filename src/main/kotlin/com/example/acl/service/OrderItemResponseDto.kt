package com.example.acl.service

/**
 * DTO for {@link com.example.acl.domain.OrderItem}
 */
data class OrderItemResponseDto(
    var id: Long? = null,
    var orderId: Long? = null,
    var productId: Long? = null,
    var count: Long? = null
)