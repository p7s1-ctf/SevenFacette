plugins {
    id("kotlin-multiplatform")
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.3.61"
}

val kotlin_version = "1.3.70"
val ktor_version = "1.3.0"
val serialization_version = "0.14.0"
val exposed_version = "0.18.1"

repositories {
    mavenCentral()
    jcenter()
    maven  ("https://dl.bintray.com/aakira/maven")
    maven ("https://jitpack.io")
}

kotlin {
    jvm() {
        compilations["main"].kotlinOptions{
            jvmTarget = "1.8"
        }
    }

    js() {
        nodejs()
        compilations["main"].kotlinOptions{
            outputFile = "${rootDir}/build/js/common.js"
            moduleKind = "plain"
            suppressWarnings = true
            sourceMap = true
            verbose = true
        }

    }

    sourceSets {
        all {
            languageSettings.useExperimentalAnnotation("kotlin.Experimental")
        }

        val commonMain by getting {
            dependencies {
                implementation (kotlin("stdlib"))
                implementation (kotlin("stdlib-common"))

                implementation ("org.jetbrains.exposed:exposed-core:0.20.1")
                implementation ("org.jetbrains.exposed:exposed-jdbc:0.20.1")

                implementation ("com.willowtreeapps.opentest4k:opentest4k-common:1.1.0")

                implementation ("io.github.microutils:kotlin-logging-common:1.7.8")

                implementation ("org.postgresql:postgresql:42.2.5")

                implementation ("io.ktor:ktor-client:$ktor_version")
                implementation ("io.ktor:ktor-client-json:$ktor_version")
                implementation ("io.ktor:ktor-client-core:$ktor_version")
                implementation ("io.ktor:ktor-client-auth:$ktor_version")
                implementation ("io.ktor:ktor-client-apache:$ktor_version")
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.0.1")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation (kotlin("test-common"))
                implementation (kotlin("test-annotations-common"))
            }
        }

        jvm().compilations["main"].defaultSourceSet {
            dependencies {
                implementation (kotlin("stdlib-jdk8"))

                implementation ("org.jetbrains.exposed:exposed-core:$exposed_version")
                implementation ("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
                implementation ("com.jayway.jsonpath:json-path:2.4.0")
                implementation ("com.fasterxml.jackson.core:jackson-databind:2.9.8")
                implementation ("org.skyscreamer:jsonassert:1.5.0")
                implementation ("io.github.microutils:kotlin-logging:1.7.8")
                implementation ("com.willowtreeapps.opentest4k:opentest4k-jvm:1.1.4")
                implementation ("org.apache.kafka:kafka-clients:2.0.0")
                implementation ("io.confluent:kafka-avro-serializer:5.0.0")
                implementation ("io.ktor:ktor-client-json-jvm:$ktor_version")
                implementation ("io.ktor:ktor-client-core-jvm:$ktor_version")
                implementation ("io.ktor:ktor-client-apache:$ktor_version")
                implementation ("io.ktor:ktor-client-auth-jvm:$ktor_version")
            }
        }

        jvm().compilations["test"].defaultSourceSet  {
            dependencies {
                implementation (kotlin("test"))
                implementation (kotlin("test-junit"))
            }
        }

        js().compilations["main"].defaultSourceSet {
            dependencies {
                implementation (kotlin("stdlib-js"))
                implementation ("io.ktor:ktor-client-js:$ktor_version")
                implementation ("io.ktor:ktor-client-core-js:$ktor_version")
                implementation ("io.ktor:ktor-client-json-js:$ktor_version")
                implementation ("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$serialization_version")
                implementation ("com.willowtreeapps.opentest4k:opentest4k-js:1.1.4")
                implementation ("io.github.microutils:kotlin-logging-js:1.7.8")
            }

        }
        js().compilations["test"].defaultSourceSet  {
            dependencies {
                implementation (kotlin("test-js"))
            }
        }
    }
}
