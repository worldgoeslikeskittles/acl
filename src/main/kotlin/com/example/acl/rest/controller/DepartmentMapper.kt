package com.example.acl.rest.controller

import com.example.acl.domain.Department
import com.example.acl.domain.User
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class DepartmentMapper {

    @Mapping(source = "managerId", target = "manager.id")
    abstract fun toEntity(departmentDto: DepartmentDto): Department

    @Mapping(source = "manager.id", target = "managerId")
    abstract fun toDto(department: Department): DepartmentDto

    @Mapping(source = "managerId", target = "manager")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(departmentDto: DepartmentDto, @MappingTarget department: Department): Department

    fun createUser(managerId: Long?): User? = managerId?.let {
        User().apply {
            this.id = managerId
        }
    }
}