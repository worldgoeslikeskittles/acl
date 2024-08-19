package com.example.acl.rest.dto

import java.math.BigDecimal

data class OrderCreateDto(val itemCount:Long, val sumPrice:BigDecimal)
