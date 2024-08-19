package com.example.acl.domain

import com.example.acl.rest.dto.StorageItemDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class StorageItemMapper {
    abstract fun toDto(storageItem: StorageItem): StorageItemDto
}