package com.example.acl.rest.controller

import com.example.acl.service.CreateOrderResponseDto
import com.example.acl.service.OrderItemResponseDto
import com.example.acl.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest/orders")
class OrderController(private val orderService: OrderService) {
    @PostMapping
    fun create(@RequestBody dto: CreateOrderDto): CreateOrderResponseDto {
        return orderService.create(dto)
    }

    @PostMapping("/{orderId}/add-item")
    fun addOrderItems(@PathVariable orderId: Long, @RequestBody dto: OrderItemDto): OrderItemResponseDto {
        return orderService.addOrderItems(orderId, dto)
    }

    @PostMapping("/{orderId}/add-items")
    fun createMany(@PathVariable orderId: Long, @RequestBody dtos: List<OrderItemDto>): List<OrderItemResponseDto> {
        return orderService.createMany(orderId, dtos)
    }

    @PostMapping("/{orderId}/shipment")
    fun createShipment(@PathVariable orderId: Long, @RequestBody dto: ShipmentDto): ShipmentDto {
        return orderService.createShipment(orderId, dto)
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): OrderExtendedDto {
        return orderService.getOne(id)
    }

    @PostMapping("/{orderId}/payment")
    fun createPaymentForOrder(@PathVariable orderId: Long, @RequestBody dto: PaymentDto): PaymentDto {
        return orderService.createOrderPayment(orderId, dto)
    }

}

