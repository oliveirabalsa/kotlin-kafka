package br.com.microservice.kotlinkafka.repository

import br.com.microservice.kotlinkafka.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long> {
}