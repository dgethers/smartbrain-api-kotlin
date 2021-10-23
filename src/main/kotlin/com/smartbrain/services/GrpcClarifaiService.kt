package com.smartbrain.services

import com.clarifai.channel.ClarifaiChannel
import com.clarifai.credentials.ClarifaiCallCredentials
import com.clarifai.grpc.api.*
import com.clarifai.grpc.api.status.StatusCode
import com.smartbrain.configurations.ClarifaiConfigurations
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class GrpcClarifaiService(@Inject val clarifaiConfigurations: ClarifaiConfigurations) : ClarifaiService {

    //todo: remove println and return model
    override fun submitImageUrlToClarifaiDemographicsWorkflow(imageUrl: String): List<Model> {

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

        val results = mutableListOf<Model>()
        postWorkflowResultsResponse.resultsList.map {
//            println("ResultSet")
            it.outputsList.map { output ->
//                println("model: ${output.model}")

                output.data.regionsList.map { region ->
//                    println("new region")
//                    println("bounding box: ${region.regionInfo.boundingBox.allFields}")
                    val regionBoundingBox = region.regionInfo.boundingBox
                    val resultBoundingBox = BoundingBox(
                        regionBoundingBox.leftCol, regionBoundingBox.topRow, regionBoundingBox.rightCol,
                        regionBoundingBox.bottomRow
                    )

                    val resultConcepts = mutableListOf<Pair<String, Float>>()
                    region.data.conceptsList.map { concept ->
//                        println("concept name: ${concept.name} with values: ${concept.value}")
                        resultConcepts.add(Pair(concept.name, concept.value))
                    }
                    results.add(Model(output.model.id, output.model.name, resultBoundingBox, resultConcepts))
                }
            }
        }

        return results
    }

}

data class BoundingBox(val startX: Float, val startY: Float, val endX: Float, val endY: Float)
data class Model(
    val id: String,
    val name: String,
    val boundingBox: BoundingBox,
    val concepts: List<Pair<String, Float>>
)