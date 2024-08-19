package com.example.acl.rest.controller

import com.example.acl.domain.PaymentStatus
import java.math.BigDecimal

/**
 * DTO for {@link com.example.acl.domain.Payment}
 */
data class PaymentDto(val cost: BigDecimal? = null, val paymentStatus: PaymentStatus? = null)