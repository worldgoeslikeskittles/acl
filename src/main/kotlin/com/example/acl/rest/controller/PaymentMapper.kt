package com.example.acl.rest.controller

import com.example.acl.domain.Payment
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class PaymentMapper {

    abstract fun toEntity(paymentDto: PaymentDto): Payment

    abstract fun toDto(payment: Payment): PaymentDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(paymentDto: PaymentDto, @MappingTarget payment: Payment): Payment
}