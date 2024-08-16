package com.example.acl.service;

import com.example.acl.domain.Customer
import com.example.acl.domain.CustomerRepository
import com.example.acl.rest.dto.customer.CustomerRegistrationDto
import org.springframework.stereotype.Service

@Service
class CustomerService(private val userService: UserService, private val customerRepository: CustomerRepository) {


    fun registerByUser(customerRegistrationDto: CustomerRegistrationDto) =
        userService.createUserForCustomer(customerRegistrationDto).let { savedUser ->
            customerRepository.save(
                Customer().apply {
                    user = savedUser
                }
            ).let {
                savedCustomer -> customerRepository.findForCustomerRegById(savedCustomer.id!!)
            }.orElseThrow()
        }
}