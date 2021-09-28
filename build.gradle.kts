plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.21"
    id("org.jetbrains.kotlin.kapt") version "1.5.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("io.micronaut.application") version "2.0.6"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.5.21"
}

version = "0.1"
group = "com.smartbrain"

val kotlinVersion=project.properties.get("kotlinVersion")
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
    runtimeOnly("ch.qos.logback:logback-classic:1.2.6")
    implementation("io.micronaut:micronaut-validation:3.0.1")

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