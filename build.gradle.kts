plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.8.10"
    application
    id("com.github.weave-mc.weave-gradle") version "bcf6ab0279"
}

group = "org.example"
version = "1.0"

repositories {
    mavenCentral()
}

repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.weave-mc:weave-loader:b40f2ae2f7")
    implementation("org.java-websocket:Java-WebSocket:1.5.4")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
}

minecraft.version("1.8.9")

kotlin {
    jvmToolchain(8)
}