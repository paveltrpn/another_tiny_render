plugins {
    application
    kotlin("jvm") version "2.0.0"
}

val lwjglVersion = "3.3.1"
val lwjglNatives = "natives-linux"

repositories {
    mavenCentral()
    // flatDir {
    //      dirs("lib")
    // }
    // flatDir {
    //      dirs("lib1", "lib2")
    // }
}

dependencies {
    // implementation("org.lwjgl:lwjgl:3.3.1")
    implementation(project(":tire:config"))
    implementation(project(":tire:render"))
}

application {
    mainClass = "usage.simple.SimpleKt"
}

