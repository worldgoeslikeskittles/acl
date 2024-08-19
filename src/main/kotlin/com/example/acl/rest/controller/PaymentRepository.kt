package com.example.acl.rest.controller;

import com.example.acl.domain.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface PaymentRepository : JpaRepository<Payment, Long>, JpaSpecificationExecutor<Payment> {
}