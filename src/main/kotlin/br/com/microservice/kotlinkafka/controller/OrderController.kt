package br.com.microservice.kotlinkafka.controller

import br.com.microservice.kotlinkafka.entity.Order
import br.com.microservice.kotlinkafka.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
class OrderController constructor(
    private val orderService: OrderService
) {

    @GetMapping
    fun all(): List<Order> {
        return orderService.all()
    }

    @GetMapping("/{id}")
    fun one(@PathVariable id: Long): Order {
        return orderService.one(id)
    }

    @PostMapping
    @ResponseBody
    fun save(@RequestBody order: Order): Order {
        return orderService.save(order)
    }
}