package de.p7s1.qa.sevenfacette.config

import de.p7s1.qa.sevenfacette.config.types.*

/**
 * TODO: Add Description
 *
 * @author Patrick Döring
 */
expect class ConfigReader {
    companion object {
        fun readConfig(): SevenFacetteConfig

        fun getHttpConfig() : HttpConfig?

        fun getHttpClientConfig(clientName: String) : HttpClientConfig?

        fun getKafkaConsumerConfig(consumerName: String) : KafkaTopicConfig?

        fun getKafkaProducerConfig(producerName: String) : KafkaTopicConfig?

        fun getDatabaseConfig(databaseName: String) : DatabaseConfig?

        fun getSeleniumConfig(seleniumConfig: String) : WebConfig?

        fun getCustomConfig(key: String) : String?

        fun getLoggingConfig() : LoggingConfig?
    }
}
