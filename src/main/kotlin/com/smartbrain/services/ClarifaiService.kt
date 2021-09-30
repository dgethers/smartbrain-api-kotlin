package com.smartbrain.services

import com.clarifai.channel.ClarifaiChannel
import com.clarifai.credentials.ClarifaiCallCredentials
import com.clarifai.grpc.api.*
import com.clarifai.grpc.api.status.StatusCode
import com.smartbrain.configurations.ClarifaiConfigurations
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class ClarifaiService(@Inject val clarifaiConfigurations: ClarifaiConfigurations) {

    //todo: remove println and return model
    fun submitImageUrlToClarifaiDemographicsWorkflow(imageUrl: String) {

        val stub: V2Grpc.V2BlockingStub = V2Grpc.newBlockingStub(ClarifaiChannel.INSTANCE.grpcChannel)
            .withCallCredentials(ClarifaiCallCredentials(clarifaiConfigurations.apiKey))

        val postWorkflowResultsResponse: PostWorkflowResultsResponse = stub.postWorkflowResults(
            PostWorkflowResultsRequest.newBuilder()
                .setWorkflowId(clarifaiConfigurations.workflowId)
                .addInputs(
                    Input.newBuilder().setData(
                        Data.newBuilder().setImage(
                            Image.newBuilder().setUrl(imageUrl)
                        )
                    )
                ).build()
        )


        if (postWorkflowResultsResponse.status.code != StatusCode.SUCCESS) {
            //todo: throw more specific exception here?
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
    }
}