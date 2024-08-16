package com.example.acl.service;

import com.example.acl.domain.Department
import com.example.acl.rest.dto.department.DepartmentDto
import com.example.acl.repository.DepartmentRepository
import com.example.acl.rest.dto.mapper.DepartmentMapper
import org.springframework.stereotype.Service

@Service
class DepartmentService(private val departmentMapper: DepartmentMapper,
                        private val departmentRepository: DepartmentRepository
) {

    fun create(dto: DepartmentDto): DepartmentDto {
        val department: Department = departmentMapper.toEntity(dto)
        val resultDepartment: Department = departmentRepository.save(department)
        return departmentMapper.toDto(resultDepartment)
    }
}