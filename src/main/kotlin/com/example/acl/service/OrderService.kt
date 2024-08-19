package com.example.acl.service;

import com.example.acl.domain.*
import com.example.acl.repository.OrderRepository
import com.example.acl.repository.ProductRepository
import com.example.acl.rest.controller.*
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val shipmentService: ShipmentService,
    private val orderMapper: OrderMapper,
    private val orderItemMapper: OrderItemMapper,
    private val orderItemRepository: OrderItemRepository,
    private val productRepository: ProductRepository, private val shipmentMapper: ShipmentMapper, private val shipmentRepository: ShipmentRepository,
    private val paymentMapper: PaymentMapper,
    private val paymentRepository: PaymentRepository
) {
    fun createOrder(entity: Order): Order {
        return orderRepository.save(entity)
    }

    //fun getFullOrder(id: Long): OrderExtendedDto =
    //orderRepository.findById(id).orElseThrow().let { shipmentService.getShipmentByOrderId(id) }

    fun create(dto: CreateOrderDto): CreateOrderResponseDto =
        orderMapper.toEntity(dto).let {
            it.orderStatus = OrderStatus.DRAFT
            orderRepository.save(it)
        }.let { orderMapper.toCreateOrderResponseDto(it) }


    //acl validation что я могу редакировать свой заказ
    fun addOrderItems(orderId: Long, dto: OrderItemDto): OrderItemResponseDto {
        val order = orderRepository.findById(orderId)
        if(order.orElseThrow().orderStatus == OrderStatus.DRAFT && //User.Role = User && my user is user who created order) {

        }
        val orderItem: OrderItem = orderItemMapper.toEntity(dto).apply {
            order = orderRepository.getReferenceById(orderId)
            product = productRepository.getReferenceById(dto.productId)
        }
        val resultOrderItem: OrderItem = orderItemRepository.save(orderItem)
        return orderItemMapper.toDto(resultOrderItem)
    }

    fun createMany(orderId: Long, dtos: List<OrderItemDto>): List<OrderItemResponseDto> = dtos.asSequence()
        .map {
            orderItemMapper.toEntity(it).apply {
                order = orderRepository.getReferenceById(orderId)
                product = productRepository.getReferenceById(it.productId)
            }
        }.also { orderItemRepository.saveAll(it.toList()) }
        .map { orderItemMapper.toDto(it) }.toList()


    fun createShipment(orderId: Long, dto: ShipmentDto): ShipmentDto {
        val shipment: Shipment = shipmentMapper.toEntity(dto)
            .apply {
                order = orderRepository.getReferenceById(orderId)
                shipmentStatus = ShipmentStatus.NOT_STARTED
            }
        val resultShipment: Shipment = shipmentRepository.save(shipment)
        return shipmentMapper.toDto(resultShipment)
    }

    @Transactional
    fun getOne(id: Long): OrderExtendedDto {
        val orderOptional: Optional<Order> = orderRepository.findById(id)
        return orderMapper.toOrderExtendedDto(orderOptional.orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `$id` not found")
        })
    }

    fun createOrderPayment(orderId: Long, dto: PaymentDto): PaymentDto {
        val payment: Payment = paymentMapper.toEntity(dto)
            .apply { order = orderRepository.getReferenceById(orderId) }
        val resultPayment: Payment = paymentRepository.save(payment)
        return paymentMapper.toDto(resultPayment)
    }

// мой отделаьный сервис который проверяет, что я могу изменять заказ в данном статусе
}