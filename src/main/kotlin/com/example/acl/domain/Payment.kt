package com.example.acl.domain

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "payment")
open class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @SequenceGenerator(name = "payment_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "cost", nullable = false, precision = 19, scale = 2)
    open var cost: BigDecimal? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    open var paymentStatus: PaymentStatus? = null

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    open var order: Order? = null
}