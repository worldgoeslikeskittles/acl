package com.example.acl.domain;

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ShipmentRepository : JpaRepository<Shipment, Long> {
    fun findShipmentByOrderId(orderId: Long): Optional<Shipment>
}