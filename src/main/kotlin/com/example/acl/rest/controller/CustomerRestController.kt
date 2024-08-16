package com.example.acl.rest.controller

import com.example.acl.domain.Customer
import com.example.acl.domain.CustomerRepository
import com.example.acl.rest.dto.customer.CustomerResponseDto
import com.example.acl.rest.dto.mapper.CustomerMapper
import com.example.acl.rest.dto.customer.CustomerRegistrationDto
import com.example.acl.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/rest/customers")
class CustomerRestController(private val customerService: CustomerService, private val customerMapper: CustomerMapper,
                             private val customerRepository: CustomerRepository
) {
    @PostMapping
    fun registerByUser(@RequestBody customerRegistrationDto: CustomerRegistrationDto): CustomerResponseDto {
        val customer: Customer = customerService.registerByUser(customerRegistrationDto)
        return customerMapper.toDto(customer)
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): CustomerResponseDto {
        val customerOptional: Optional<Customer> = customerRepository.findById(id)
        return customerMapper.toDto(customerOptional.orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `$id` not found")
        })
    }
}

