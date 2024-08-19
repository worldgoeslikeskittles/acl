package com.example.acl.rest.controller

import com.example.acl.domain.Shipment
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class ShipmentMapper {

    abstract fun toEntity(shipmentDto: ShipmentDto): Shipment

    abstract fun toDto(shipment: Shipment): ShipmentDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(shipmentDto: ShipmentDto, @MappingTarget shipment: Shipment): Shipment
}