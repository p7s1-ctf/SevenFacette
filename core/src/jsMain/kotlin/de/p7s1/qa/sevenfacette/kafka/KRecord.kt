package de.p7s1.qa.sevenfacette.kafka

/**
 * TODO: Add Description
 *
 * @author Patrick Döring
 */
data class KRecord(var key: String?, var value: String?, var offset: Int, var partition: Int) {}
