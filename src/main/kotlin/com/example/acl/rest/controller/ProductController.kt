package com.example.acl.rest.controller

import com.example.acl.rest.dto.product.ProductDto
import com.example.acl.rest.dto.product.ProductResponseDto
import com.example.acl.service.ProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/rest/products")
class ProductController(private val productService: ProductService) {

    @PostMapping("/create")
    fun create(@RequestBody dto: ProductDto): ProductResponseDto = productService.create(dto)
}

