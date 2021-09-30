package com.smartbrain.controllers

import com.clarifai.channel.ClarifaiChannel
import com.clarifai.credentials.ClarifaiCallCredentials
import com.clarifai.grpc.api.*
import com.clarifai.grpc.api.status.StatusCode.SUCCESS
import io.grpc.Channel
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

        val channel: Channel = ClarifaiChannel.INSTANCE.grpcChannel
        val stub: V2Grpc.V2BlockingStub = V2Grpc.newBlockingStub(channel)
            .withCallCredentials(ClarifaiCallCredentials("5ad05aba895a401cb4a81129e31f35a5"))

        val postWorkflowResultsResponse: PostWorkflowResultsResponse = stub.postWorkflowResults(
            PostWorkflowResultsRequest.newBuilder()
                .setWorkflowId("Demographics")
                .addInputs(
                    Input.newBuilder().setData(
                        Data.newBuilder().setImage(
                            Image.newBuilder().setUrl("https://cdn7.dissolve.com/p/D430_35_159/D430_35_159_1200.jpg")
                        )
                    )
                ).build()
        )


        if (postWorkflowResultsResponse.status.code != SUCCESS) {
            throw RuntimeException("Post workflow results failed, status: " + postWorkflowResultsResponse.status)
        }

        postWorkflowResultsResponse.resultsList.map {
            println("ResultSet")
            it.outputsList.map { output ->
                println("model: ${output.model}")

                output.data.regionsList.map { region ->
                    println("new region")
                    println("bounding box: ${region.regionInfo.boundingBox.allFields}")

                    region.data.conceptsList.map { concept ->
                        println("concept name: ${concept.name} with values: ${concept.value}")
                    }
                }
            }
        }

        val fileBytes = file.bytes
        val fileName = file.filename
        return HttpResponse.ok("file name -> $fileName; byte array size -> ${fileBytes.size}")
    }
}