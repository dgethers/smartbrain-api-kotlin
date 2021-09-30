package com.smartbrain.controllers

import com.smartbrain.services.ClarifaiService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.MediaType.MULTIPART_FORM_DATA
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.multipart.CompletedFileUpload
import jakarta.inject.Inject

@Controller("/demographics")
class DemographicsController(@Inject val clarifaiService: ClarifaiService) {

    @Post("/")
    @Consumes(MULTIPART_FORM_DATA)
    @Produces(APPLICATION_JSON)
    fun uploadFile(file: CompletedFileUpload): HttpResponse<String> {


        val url = "https://cdn7.dissolve.com/p/D430_35_159/D430_35_159_1200.jpg"
        clarifaiService.submitImageUrlToClarifaiDemographicsWorkflow(url)
        val fileBytes = file.bytes
        val fileName = file.filename
        return HttpResponse.ok("file name -> $fileName; byte array size -> ${fileBytes.size}")
    }
}