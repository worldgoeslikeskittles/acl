package com.example.acl.service;

import com.example.acl.rest.dto.mapper.UserMapper
import com.example.acl.domain.Role
import com.example.acl.domain.User
import com.example.acl.domain.UserRole
import com.example.acl.repository.UserRepository
import com.example.acl.rest.dto.customer.CustomerRegistrationDto
import com.example.acl.rest.dto.user.UserDto
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userMapper: UserMapper, private val userRepository: UserRepository
) {
    fun create(dto: UserDto): UserDto {
        val user: User = userMapper.toEntity(dto)
        val resultUser: User = userRepository.save(user)
        return userMapper.toDto(resultUser)
    }

    fun createUserForCustomer(dto: CustomerRegistrationDto): User =
        userMapper.customerRegDtoToEntity(dto)!!
            .let {
                it.userRoles.add(UserRole()
                    .apply {
                        role = Role.CUSTOMER
                        user = it
                    }
                )
               userRepository.save(it)
            }
}