package com.smartbrain.controllers

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType.APPLICATION_JSON
import io.micronaut.http.MediaType.MULTIPART_FORM_DATA
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.multipart.CompletedFileUpload

@Controller("/demographics")
class DemographicsController {

    @Post("/")
    @Consumes(MULTIPART_FORM_DATA)
    @Produces(APPLICATION_JSON)
    fun uploadFile(file: CompletedFileUpload): HttpResponse<String> {

        val fileBytes = file.bytes
        val fileName = file.filename
        return HttpResponse.ok("file name -> $fileName; byte array size -> ${fileBytes.size}")
    }
}