package com.example.acl.rest.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/rest/users")
class UserController(private val userService: UserService) {
    @PostMapping
    fun create(@RequestBody dto: UserDto): UserDto {
        return userService.create(dto)
    }

}

