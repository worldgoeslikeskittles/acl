package com.example.acl.rest.controller

import com.example.acl.domain.Customer
import com.example.acl.domain.Order
import com.example.acl.domain.OrderItem
import com.example.acl.service.CreateOrderResponseDto
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class OrderMapper {

    @Mapping(source = "customerId", target = "customer.id")
    abstract fun toEntity(createOrderDto: CreateOrderDto): Order

    @Mapping(source = "customer.id", target = "customerId")
    abstract fun toDto(order: Order): CreateOrderDto

    @Mapping(source = "customerId", target = "customer")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(createOrderDto: CreateOrderDto, @MappingTarget order: Order): Order

    fun createCustomer(customerId: Long?): Customer? = customerId?.let {
        Customer().apply {
            this.id = customerId
        }
    }

    @Mapping(source = "customer.id", target = "customerId")
    abstract fun toCreateOrderResponseDto(order: Order): CreateOrderResponseDto

    @AfterMapping
    fun linkOrderItems(@MappingTarget order: Order) {
        order.orderItems.forEach { it.order = order }
    }

    abstract fun toOrderExtendedDto(order: Order): OrderExtendedDto

    @Mapping(source = "user.name", target = "name")
    abstract fun toCustomerDto(customer: Customer): OrderExtendedDto.CustomerDto

    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.description", target = "productDescription")
    abstract fun toOrderItemDto(orderItem: OrderItem): OrderExtendedDto.OrderItemDto1
}