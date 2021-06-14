package br.com.microservice.kotlinkafka.entity

import javax.persistence.*

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    val price: Float,

    @Column(nullable = false)
    val status: String
)
