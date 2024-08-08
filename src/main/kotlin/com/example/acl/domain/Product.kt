package com.example.acl.domain

import jakarta.persistence.*

@Entity
@Table(name = "product")
open class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Lob
    @Column(name = "description")
    open var description: String? = null

}