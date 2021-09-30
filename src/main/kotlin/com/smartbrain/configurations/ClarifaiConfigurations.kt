package com.smartbrain.configurations

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("clarifai")
class ClarifaiConfigurations {

    lateinit var workflowId: String
    lateinit var apiKey: String
}