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

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH])
    @JoinTable(
        name = "user_userRoles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "userRoles_id")]
    )
    open var userRoles: MutableSet<UserRole> = mutableSetOf()

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL], optional = true, orphanRemoval = true)
    open var userCredentials: UserCredentials? = null
}