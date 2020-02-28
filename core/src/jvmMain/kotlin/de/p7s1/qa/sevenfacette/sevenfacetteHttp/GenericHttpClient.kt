package de.p7s1.qa.sevenfacette.sevenfacetteHttp

import de.p7s1.qa.sevenfacette.config.RestServiceAuth
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.content.ByteArrayContent
import io.ktor.http.content.TextContent
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


actual open class GenericHttpClient actual constructor() {

    actual val client = HttpClient()
    actual var url = Url()
    actual var auth: RestServiceAuth? = null

    actual fun auth(auth: RestServiceAuth): GenericHttpClient {
        this.auth = auth
        return this
    }

    actual fun url(url: Url): GenericHttpClient {
        this.url = url
        return this
    }

    actual fun post(path: String, content: String, headers: httpHeader): httpResponse {
        return this.executeRequest(HttpMethod.Post, path, content, headers)
    }

    actual fun postByteArray(path: String, content: ByteArray, headers: httpHeader): httpResponse {
        TODO()
    }

    actual fun put(path: String, content: String, headers: httpHeader): httpResponse {
        TODO()
    }

    actual fun putByteArray(path: String, content: ByteArray, headers: httpHeader): httpResponse {
        TODO()
    }

    actual fun delete(path: String, headers: httpHeader): httpResponse {
        return this.executeRequest<Unit>(HttpMethod.Delete, path, null, headers)
    }

    actual fun get(path: String, headers: httpHeader): httpResponse {
        return this.executeRequest<Unit>(HttpMethod.Get, path, null, headers)
    }

    private inline fun <reified T> executeRequest(useMethod: HttpMethod, usePath: String, useContent: T?, useHeaders: httpHeader): httpResponse {
        val facetteResponses = mutableListOf<httpResponse>()
        val fullPath = this.url.path(usePath).create()

        runBlocking {
            launch {
                facetteResponses.add(httpResponse(client.request{
                    url(fullPath)

                    method = useMethod

                    if(useContent != null) {
                        body = getBody(useContent)
                    }

                    useHeaders.header.forEach {
                        headers.append(it.first, it.second)
                    }
                }))
            }.join()
        }

        require(facetteResponses.size == 1, { println("No result found") })
        return facetteResponses[0]
    }

    private inline fun <reified T> getBody(content: T): Any {
        return when(T::class) {
            String::class, Unit::class -> TextContent(content as String, ContentType.Application.Json)
            ByteArray::class -> ByteArrayContent(content as ByteArray)
            else -> throw Error("Content not supported")
        }
    }
}
