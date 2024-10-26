
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.21"
    id("io.ktor.plugin") version "3.0.0"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.cio.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-cio-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-config-yaml")
    testImplementation("io.ktor:ktor-server-test-host-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
