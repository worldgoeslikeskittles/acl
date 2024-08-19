package com.example.acl.rest.controller

import com.example.acl.domain.Order
import com.example.acl.domain.OrderItem
import com.example.acl.domain.Product
import com.example.acl.service.OrderItemResponseDto
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class OrderItemMapper {

    @Mapping(source = "productId", target = "product.id", ignore = true)
    abstract fun toEntity(orderItemDto: OrderItemDto): OrderItem

    @Mapping(source = "productId", target = "product")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(orderItemDto: OrderItemDto, @MappingTarget orderItem: OrderItem): OrderItem

    fun createProduct(productId: Long?): Product? = productId?.let {
        Product().apply {
            this.id = productId
        }
    }

    //@InheritInverseConfiguration(name = "toEntity")
    @Mappings(Mapping(target = "orderId", source = "order.id"), Mapping(target = "productId", source = "product.id"))
    abstract fun toDto(orderItem: OrderItem): OrderItemResponseDto
}