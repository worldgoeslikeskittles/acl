package com.example.acl.rest.dto.mapper

import com.example.acl.domain.Customer
import com.example.acl.domain.Role
import com.example.acl.domain.UserRole
import com.example.acl.rest.dto.customer.CustomerResponseDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingConstants
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class CustomerMapper {
    @Mapping(source = "user.userRoles", target = "userRoles")
    @Mapping(source = "user.name", target = "userName")
    abstract fun toDto(customer: Customer): CustomerResponseDto

    fun toRole(userRole: UserRole): Role? = userRole.role
}