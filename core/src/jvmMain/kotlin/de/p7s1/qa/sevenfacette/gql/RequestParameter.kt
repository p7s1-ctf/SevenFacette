package de.p7s1.qa.sevenfacette.gql

import java.util.HashMap

/**
 * Represents request parameter.
 *
 * @author Patrick Döring
 */
class RequestParameter private constructor() : HashMap<String?, Any?>() {

    fun addParameter(key: String?, obj: Any?): RequestParameter {
        put(key, obj)
        return this
    }

    fun addObjectParameter(key: String?, obj: Any?): RequestParameter {
        (obj as? RequestObjectParameter)?.let { put(key, it) } ?: put(
            key,
            RequestObjectParameter(obj!!)
        )
        return this
    }

    override fun toString(): String {
        val keys: MutableSet<String?> = keys
        if (keys.size == 0) {
            return ""
        }
        var stringVal = "("
        val connect = ','
        for (key in keys) {
            stringVal = stringVal + key + ":" + packVal(get(key)) + connect
        }
        val last = stringVal[stringVal.length - 1]
        if (connect == last) {
            stringVal = stringVal.substring(0, stringVal.length - 1)
        }
        stringVal = "$stringVal)"
        return stringVal
    }

    private fun packVal(`val`: Any?): String {
        if (`val` == null) {
            return "null"
        }
        if (`val` is Int
            || `val` is Boolean
            || `val` is Float
            || `val` is Double
        ) {
            return `val`.toString()
        }
        if (`val` is Enum<*>) {
            return `val`.name
        }
        return (`val` as? RequestObjectParameter)?.toString() ?: "\\\"" + `val`.toString() + "\\\""
    }

    companion object {

        fun buildByMap(map: Map<*, *>): RequestParameter {
            val requestParameter = build()
            map.forEach { (any, any2) -> requestParameter[any as String?] = any2 }

            //requestParameter.putAll(map)
            return requestParameter
        }

        fun build(): RequestParameter {
            return RequestParameter()
        }
    }
}
