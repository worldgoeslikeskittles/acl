package com.example.acl.domain

import jakarta.persistence.*

@Entity
@Table(name = "storage")
open class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storage_seq")
    @SequenceGenerator(name = "storage_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "storage_number", nullable = false)
    open var storageNumber: String? = null

    @OneToMany(mappedBy = "storage", orphanRemoval = true)
    open var storageItems: MutableSet<StorageItem> = mutableSetOf()
}