package br.com.microservice.kotlinkafka.service

import br.com.microservice.kotlinkafka.entity.Order
import br.com.microservice.kotlinkafka.repository.OrderRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OrderService constructor(
    private val orderRepository: OrderRepository,
    private val producerService: ProducerService
) {
    fun all(): List<Order> {
        val orders = orderRepository.findAll()
        producerService.produce(orders)
        return orders

    }

    fun one(id: Long): Order {
        return orderRepository.findByIdOrNull(id) ?: throw Exception("Order not found")
    }

    fun save(order: Order): Order {
        return orderRepository.save(order)
    }
}