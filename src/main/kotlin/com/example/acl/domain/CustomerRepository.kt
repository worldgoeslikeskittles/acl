package com.example.acl.domain;

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CustomerRepository : JpaRepository<Customer, Long> {

    @EntityGraph(attributePaths = ["user.userRoles"])
    fun findForCustomerRegById(id: Long): Optional<Customer>
}