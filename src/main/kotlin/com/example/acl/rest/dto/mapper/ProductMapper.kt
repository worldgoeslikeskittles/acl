package com.example.acl.rest.dto.mapper

import com.example.acl.domain.Product
import com.example.acl.rest.dto.product.ProductDto
import com.example.acl.rest.dto.product.ProductResponseDto
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class ProductMapper {

    abstract fun toEntity(productDto: ProductDto): Product

    abstract fun toDto(product: Product): ProductDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(productDto: ProductDto, @MappingTarget product: Product): Product

    abstract fun toEntity1(productResponseDto: ProductResponseDto): Product

    abstract fun toResponseDto(product: Product): ProductResponseDto

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate1(productResponseDto: ProductResponseDto, @MappingTarget product: Product): Product
}