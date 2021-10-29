package com.smartbrain.controllers

import com.smartbrain.models.ImageRequest
import com.smartbrain.services.BoundingBox
import com.smartbrain.services.ClarifaiService
import com.smartbrain.services.GrpcClarifaiService
import com.smartbrain.services.Model
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.annotation.*
import jakarta.inject.Inject

@Controller("/demographics")
class DemographicsController(@Inject val clarifaiService: ClarifaiService) {


    @Post("/")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    //todo: add validation to ensure imageUrl is not null
    fun predictDemographics(@Body imageRequest: ImageRequest): HttpResponse<List<Pair<BoundingBox, MutableList<Model>>>> {

        val demographicResponse = clarifaiService.submitImageUrlToClarifaiDemographicsWorkflow(imageRequest.imageUrl)

        return HttpResponse.ok(demographicResponse)
    }

}