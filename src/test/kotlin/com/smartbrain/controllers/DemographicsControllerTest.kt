package com.smartbrain.controllers

import com.smartbrain.models.ImageRequest
import com.smartbrain.services.GrpcClarifaiService
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest.POST
import io.micronaut.http.HttpStatus.OK
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.just
import io.mockk.mockk
import jakarta.inject.Inject

@MicronautTest
class DemographicsControllerTest(@Inject @Client("/") var client: HttpClient) : ShouldSpec({

    lateinit var clarifaiService: GrpcClarifaiService

//    beforeTest {
//        clarifaiService = mockk()
//    }

    should("submit the url to Clarifai service for predictions") {
        val imageUrl = "https://cdn7.dissolve.com/p/D430_35_159/D430_35_159_1200.jpg"
//        every { clarifaiService.submitImageUrlToClarifaiDemographicsWorkflow(imageUrl) } returns emptyList()

        val response = client.toBlocking().exchange(
            POST("/demographics", ImageRequest(imageUrl)),
            ImageRequest::class.java
        )

        println(response)

        response.status shouldBe OK
    }
})