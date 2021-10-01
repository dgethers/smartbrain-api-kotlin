package com.smartbrain.controllers

import com.smartbrain.models.ImageRequest
import com.smartbrain.services.ClarifaiService
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest.POST
import io.micronaut.http.HttpStatus.OK
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import jakarta.inject.Inject

@MicronautTest
class DemographicsControllerTest(@Inject @Client("/") var client: HttpClient) : ShouldSpec({


    should("submit the url to Clarifai service for predictions") {
        @MockBean
        private ClarifaiService 

        val response = client.toBlocking().exchange(
            POST("/demographics", ImageRequest("https://cdn7.dissolve.com/p/D430_35_159/D430_35_159_1200.jpg")),
            ImageRequest::class.java
        )

        response.status shouldBe OK
    }
})