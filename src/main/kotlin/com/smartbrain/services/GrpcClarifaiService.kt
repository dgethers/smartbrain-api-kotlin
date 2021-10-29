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

    override fun submitImageUrlToClarifaiDemographicsWorkflow(imageUrl: String): List<Pair<BoundingBox, MutableList<Model>>> {

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

        val boundingBox = mutableMapOf<BoundingBox, MutableList<Model>>()
        postWorkflowResultsResponse.resultsList.map {
            it.outputsList.map { output ->

                output.data.regionsList.map { region ->
                    val regionBoundingBox = region.regionInfo.boundingBox
                    val resultBoundingBox = BoundingBox(regionBoundingBox.bottomRow, regionBoundingBox.leftCol,
                        regionBoundingBox.topRow, regionBoundingBox.rightCol)

                    val concepts = mutableListOf<Concept>()
                    region.data.conceptsList.map { concept ->
                        concepts.add(Concept(concept.name, concept.value))
                    }

                    if (!boundingBox.containsKey(resultBoundingBox)) {
                        boundingBox.put(resultBoundingBox, mutableListOf(Model(output.model.name, concepts)))
                    } else {
                        val models = boundingBox[resultBoundingBox]
                        models?.add(Model(output.model.name, concepts))
                    }
                }
            }
        }

        return boundingBox.toList()
    }

}

data class BoundingBox(val bottomRow: Float, val leftColumn: Float, val topRow: Float, val rightColumn: Float)
data class Model(
    val name: String,
    val concepts: List<Concept>
)
data class Concept(val name: String, val value: Float)