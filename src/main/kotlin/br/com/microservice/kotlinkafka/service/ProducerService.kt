package br.com.microservice.kotlinkafka.service
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.Properties;
import org.springframework.stereotype.Service

@Service
class ProducerService {
    private fun createProducer(): Producer<String, String> {
        val props = Properties()
        props["bootstrap.servers"] = "localhost:9092"
        props["key.serializer"] = StringSerializer::class.java
        props["value.serializer"] = StringSerializer::class.java
        return KafkaProducer<String, String>(props)
    }

    fun produce(file: Any) {
        val producer = createProducer()
            val future = producer.send(ProducerRecord("Topic1", file.toString(), file.toString()))
            future.get()
    }
}