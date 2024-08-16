package com.example.acl.rest.dto.department

/**
 * DTO for {@link com.example.acl.domain.Department}
 */
data class DepartmentDto(val managerId: Long? = null, val name: String? = null) {
    private constructor() : this(null)
}