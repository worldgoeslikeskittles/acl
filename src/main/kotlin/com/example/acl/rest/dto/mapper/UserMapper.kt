package com.example.acl.rest.dto.mapper

import com.example.acl.domain.Department
import com.example.acl.domain.Role
import com.example.acl.domain.User
import com.example.acl.domain.UserRole
import com.example.acl.rest.controller.UserDto
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class UserMapper {

    @Mappings(
        Mapping(source = "workPlaceId", target = "department", qualifiedByName = ["createDepartment"]),
        Mapping(source = "userCredentialsLogin", target = "userCredentials.login"),
        Mapping(source = "userCredentialsPassword", target = "userCredentials.password"),
        Mapping(source = "userRoleRoles", target = "userRoles", qualifiedByName = ["RolesToUserRoles"]),
    )
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun toEntity(userDto: UserDto): User

    @InheritInverseConfiguration(name = "toEntity")
    @Mapping(source = "department.id", target = "workPlaceId")
    @Mapping(source = "userRoles", target = "userRoleRoles", qualifiedByName = ["userRolesToUserRoleRoles"])
    abstract fun toDto(user: User): UserDto

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(userDto: UserDto, @MappingTarget user: User): User

    @Named("createDepartment")
    fun createDepartment(workPlaceId: Long): Department = workPlaceId.let {
                Department().apply {
                    this.id = workPlaceId
                }
            }

    @Named("userRolesToUserRoleRoles")
    fun userRolesToUserRoleRoles(userRoles: MutableSet<UserRole>): MutableSet<Role?> {
        return userRoles.map { it.role }.toMutableSet()
    }

    @Named("RolesToUserRoles")
    fun rolesToUserRoles(roles: MutableSet<Role?>): Set<UserRole> = roles.map { givenRole-> UserRole().apply { role = givenRole } }.toMutableSet()
}