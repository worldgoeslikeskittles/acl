package com.example.acl.rest.controller;

import com.example.acl.domain.Department
import com.example.acl.domain.User
import com.example.acl.repository.UserRepository
import com.example.acl.rest.dto.mapper.UserMapper
import org.springframework.stereotype.Service

@Service
class UserService(private val userMapper: UserMapper, private val userRepository: UserRepository
) {
    fun create(dto: UserDto): UserDto {
        val user: User = userMapper.toEntity(dto)
        val resultUser: User = userRepository.save(user)
        return userMapper.toDto(resultUser)
    }
}