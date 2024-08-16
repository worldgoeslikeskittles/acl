package com.example.acl.domain

import jakarta.persistence.*

@Entity
@Table(name = "user_")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    open var department: Department? = null

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var userRoles: MutableSet<UserRole> = mutableSetOf()

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL], optional = true, orphanRemoval = true)
    open var userCredentials: UserCredentials? = null

    @Column(name = "name")
    open var name: String? = null
}