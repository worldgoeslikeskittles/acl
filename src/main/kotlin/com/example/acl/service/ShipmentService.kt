package com.example.acl.service;

import com.example.acl.domain.Shipment
import com.example.acl.domain.ShipmentRepository
import org.springframework.stereotype.Service

@Service
class ShipmentService(private val shipmentRepository: ShipmentRepository) {

    fun getShipmentByOrderId(orderId: Long): Shipment {
        return shipmentRepository.findShipmentByOrderId(orderId).orElseThrow()
    }
}