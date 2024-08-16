package com.example.acl.repository;

import com.example.acl.domain.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface DepartmentRepository : JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {
}