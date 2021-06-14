package br.com.microservice.kotlinkafka.service

import br.com.microservice.kotlinkafka.entity.Order
import br.com.microservice.kotlinkafka.repository.OrderRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OrderService constructor(
    private val orderRepository: OrderRepository
) {
    fun all(): List<Order> {
        return orderRepository.findAll()
    }

    fun one(id: Long): Order {
        return orderRepository.findByIdOrNull(id) ?: throw Exception("Order not found")
    }

    fun save(order: Order): Order {
        return orderRepository.save(order)
    }
}