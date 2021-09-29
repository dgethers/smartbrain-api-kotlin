package com.smartbrain.controllers

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus.OK
import io.micronaut.http.MediaType.MULTIPART_FORM_DATA_TYPE
import io.micronaut.http.MediaType.TEXT_PLAIN_TYPE
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.multipart.MultipartBody
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject
import java.io.File

@MicronautTest
class DemographicsControllerTest(@Inject @Client("/") var client: HttpClient) : ShouldSpec({

    should("successfully upload file") {
        val file = File.createTempFile("data", ".jpg")
        val requestBody = MultipartBody.builder()
            .addPart(
                "file",
                file.name,
                TEXT_PLAIN_TYPE,
                file
            ).build()

        val request = HttpRequest.POST("/demographics", requestBody)
            .contentType(MULTIPART_FORM_DATA_TYPE)
        val response: HttpResponse<String> =
            client.toBlocking().exchange(request, String::class.java)

        response.status shouldBe OK
        response.body() shouldBe "file name -> ${file.name}; byte array size -> 0"
    }

})
