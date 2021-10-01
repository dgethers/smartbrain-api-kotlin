import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.21"
    id("org.jetbrains.kotlin.kapt") version "1.5.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("io.micronaut.application") version "2.0.6"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.5.21"
    id("com.google.protobuf") version "0.8.14"
}

version = "0.1"
group = "com.smartbrain"
val protocVersion = "3.12.2"
val grpcVersion = "1.30.0"
val kotlinVersion = project.properties.get("kotlinVersion")

repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("com.smartbrain.*")
    }
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation:3.0.1")
    implementation("io.micronaut:micronaut-http-client:3.0.1")
    implementation("io.micronaut:micronaut-runtime:3.0.1")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime:3.0.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("io.micronaut:micronaut-validation:3.0.1")
    implementation("io.grpc:grpc-kotlin-stub:0.1.2")
    implementation("io.micronaut.grpc:micronaut-grpc-client-runtime:3.0.0")
    implementation("com.clarifai:clarifai-grpc:7.9.0")
    testImplementation("io.kotest:kotest-assertions-core")
    testImplementation("io.mockk:mockk:1.12.0")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.6")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
}


application {
    mainClass.set("com.example.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("1.8")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

sourceSets {
    main {
        java {
            srcDirs(
                "build/generated/source/proto/main/grpc",
                "build/generated/source/proto/main/grpckt",
                "build/generated/source/proto/main/java"
            )
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${protocVersion}"
    }
}