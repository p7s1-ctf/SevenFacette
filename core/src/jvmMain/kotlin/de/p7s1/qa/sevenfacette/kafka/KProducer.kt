package de.p7s1.qa.sevenfacette.kafka

import de.p7s1.qa.sevenfacette.kafka.config.KTableTopicConfig
import de.p7s1.qa.sevenfacette.kafka.config.SaslConfiguration
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

/**
 * JVM specific implementation of the Kafka producer
 *
 * @constructor the constructor receives the [tableTopicConfig] and [autoSend] parameter
 *
 * @author Patrick Döring
 */
class KProducer (private val tableTopicConfig: KTableTopicConfig,
                 private var autoSend: Boolean
) {
    private lateinit var producer : KafkaProducer<String, String>

    /**
     * Create a KafkaProducer
     * @return [producer]
     */
    fun createProducer() : KafkaProducer<String, String> {
        var config : MutableMap<String, Any> = mutableMapOf()
        config[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = tableTopicConfig.kafkaConfig.bootstrapServer
        config[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        config[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java

        if (tableTopicConfig.kafkaConfig.useSASL) {
            config = SaslConfiguration.addSaslProperties(config, tableTopicConfig)
        }
        producer = KafkaProducer<String, String>(config)
        return producer
    }

    /**
     * Sends a Kafka message to a configured table topic
     * @param [msg]
     */
    fun send(msg: String) {
        producer.send(ProducerRecord(tableTopicConfig.kafkaTopic, msg))
        if (autoSend) {
            flush()
        }
    }

    /**
     * Sends a Kafka message with key to a configured table topic
     * @param [key]
     * @param [msg]
     */
    fun sendKeyMessage(key: String, msg: String) {
        producer.send(ProducerRecord(tableTopicConfig.kafkaTopic, key, msg))
    }

    /**
     * Flush records currently buffered in the producer
     */
    fun flush() = producer.flush()

    /**
     * Returns the configured table topic
     * @return [tableTopicConfig.kafkaTopic]
     */
    fun getTopic() : String {
        return tableTopicConfig.kafkaTopic
    }
}
