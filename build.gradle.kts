plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.22"
    application
    id("com.github.weave-mc.weave-gradle") version "fac948db7f"
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
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
}

minecraft.version("1.8.9")

kotlin {
    jvmToolchain(8)
}

