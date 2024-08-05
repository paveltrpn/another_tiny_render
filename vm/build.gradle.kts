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
    implementation("org.lwjgl", "lwjgl", lwjglVersion)
    implementation("org.lwjgl", "lwjgl-glfw", lwjglVersion)
    implementation("org.lwjgl", "lwjgl-jemalloc", lwjglVersion)
    implementation("org.lwjgl", "lwjgl-opengl", lwjglVersion)
    implementation("org.lwjgl", "lwjgl-vulkan", lwjglVersion)
    runtimeOnly("org.lwjgl", "lwjgl", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-glfw", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-jemalloc", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-opengl", classifier = lwjglNatives)
}

application {
    mainClass = "kov.vm.VmKt"
}

