plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.8.10"
    application
    id("com.github.weave-mc.weave-gradle") version "master"
}

group = "me.lished"
version = "1.0"
buildDir = File("C:/Users/Sentinel/.weave/mods")

repositories {
    mavenCentral()
}

repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.weave-mc:weave-loader:master")
    implementation("org.java-websocket:Java-WebSocket:1.5.4")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
}

minecraft.version("1.8.9")

kotlin {
    jvmToolchain(8)
}

