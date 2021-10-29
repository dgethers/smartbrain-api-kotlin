package com.smartbrain.services

interface ClarifaiService {
    fun submitImageUrlToClarifaiDemographicsWorkflow(imageUrl: String): List<Pair<BoundingBox, MutableList<Model>>>
}