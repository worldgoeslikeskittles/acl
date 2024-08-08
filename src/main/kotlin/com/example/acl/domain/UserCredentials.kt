package com.example.acl.domain

import jakarta.persistence.*

@Entity
@Table(name = "user_credentials")
open class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_credentials_seq")
    @SequenceGenerator(name = "user_credentials_seq")
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToOne(fetch = FetchType.LAZY, optional = true, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    open var user: User? = null

    @Column(name = "login", nullable = false)
    open var login: String? = null

    @Column(name = "password", nullable = false)
    open var password: String? = null
}