package com.example.acl.rest.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/rest/departments")
class DepartmentController(private val departmentService: DepartmentService) {
    @PostMapping
    fun create(@RequestBody dto: DepartmentDto): DepartmentDto {
        return departmentService.create(dto)
    }

}

