package com.example.acl.domain

import jakarta.persistence.*

@Entity
@Table(name = "shipment")
open class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_seq")
    @SequenceGenerator(name = "shipment_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = false)
    open var order: Order? = null

    @Column(name = "delivery_address", nullable = false)
    open var deliveryAddress: String? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "shipment_status", nullable = false)
    open var shipmentStatus: ShipmentStatus? = null
}