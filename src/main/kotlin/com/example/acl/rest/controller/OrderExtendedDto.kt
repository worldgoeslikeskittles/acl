package com.example.acl.rest.controller

import com.example.acl.domain.PaymentStatus
import com.example.acl.domain.ShipmentStatus
import java.math.BigDecimal

/**
 * DTO for {@link com.example.acl.domain.Order}
 */
data class OrderExtendedDto(
    var id: Long? = null,
    var customer: CustomerDto? = null,
    var orderItems: MutableSet<OrderItemDto1> = mutableSetOf(),
    var payment: PaymentDto? = null,
    var shipment: ShipmentDto1? = null
) {
    /**
     * DTO for {@link com.example.acl.domain.Customer}
     */
    data class CustomerDto(var id: Long? = null, var name: String? = null)

    /**
     * DTO for {@link com.example.acl.domain.OrderItem}
     */
    data class OrderItemDto1(
        var id: Long? = null,
        var productName: String? = null,
        var productDescription: String? = null,
        var count: Long? = null
    )

    /**
     * DTO for {@link com.example.acl.domain.Payment}
     */
    data class PaymentDto(var cost: BigDecimal? = null, var paymentStatus: PaymentStatus? = null)

    /**
     * DTO for {@link com.example.acl.domain.Shipment}
     */
    data class ShipmentDto1(var deliveryAddress: String? = null, var shipmentStatus: ShipmentStatus? = null)
}