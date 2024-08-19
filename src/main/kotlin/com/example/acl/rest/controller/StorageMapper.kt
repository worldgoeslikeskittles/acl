package com.example.acl.rest.controller

import com.example.acl.domain.Storage
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class StorageMapper {

    abstract fun toEntity(createStorageDto: CreateStorageDto): Storage

    abstract fun toDto(storage: Storage): CreateStorageDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(createStorageDto: CreateStorageDto, @MappingTarget storage: Storage): Storage
}