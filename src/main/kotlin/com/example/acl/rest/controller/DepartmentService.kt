package com.example.acl.rest.controller;

import com.example.acl.domain.Department
import org.springframework.stereotype.Service

@Service
class DepartmentService(private val departmentMapper: DepartmentMapper,
                        private val departmentRepository: DepartmentRepository) {

    fun create(dto: DepartmentDto): DepartmentDto {
        val department: Department = departmentMapper.toEntity(dto)
        val resultDepartment: Department = departmentRepository.save(department)
        return departmentMapper.toDto(resultDepartment)
    }
}