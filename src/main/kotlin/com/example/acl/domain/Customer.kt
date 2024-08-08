package com.example.acl.domain

import jakarta.persistence.*

@Entity
@Table(name = "customer")
open class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
    open var user: User? = null

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    open var orders: MutableSet<Order> = mutableSetOf()
}