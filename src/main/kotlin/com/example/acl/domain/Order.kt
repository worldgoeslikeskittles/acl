package com.example.acl.domain

import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy

@Entity
@Table(name = "order_")
open class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    open var customer: Customer? = null

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    open var orderItems: MutableSet<OrderItem> = mutableSetOf()

    @OneToOne(orphanRemoval = true, mappedBy = "order")
    open var payment: Payment? = null

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true, mappedBy = "order" )
    open var shipment: Shipment? = null


    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    open var orderStatus: OrderStatus? = null

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as Order

        return id != null && id == other.id
    }

    final override fun hashCode(): Int =
        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()
}