package com.smartbrain.services

interface ClarifaiService {
    //todo: remove println and return model
    fun submitImageUrlToClarifaiDemographicsWorkflow(imageUrl: String): List<Model>
}