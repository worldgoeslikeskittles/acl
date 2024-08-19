package com.example.acl.rest.controller;

import com.example.acl.domain.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface OrderItemRepository : JpaRepository<OrderItem, Long>, JpaSpecificationExecutor<OrderItem> {
}