package com.example.acl.service;

import com.example.acl.domain.Product
import com.example.acl.repository.ProductRepository
import com.example.acl.rest.dto.mapper.ProductMapper
import com.example.acl.rest.dto.product.ProductDto
import com.example.acl.rest.dto.product.ProductResponseDto
import org.springframework.stereotype.Service

@Service
class ProductService(private val productMapper: ProductMapper, private val productRepository: ProductRepository) {
    fun create(dto: ProductDto): ProductResponseDto = productMapper.toEntity(dto)
            .also { productRepository.save(it) }
            .let { productMapper.toResponseDto(it) }

    fun findById(id: Long ): Product = productRepository.findById(id).orElseThrow()
    }

