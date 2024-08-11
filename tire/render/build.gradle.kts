plugins {
    kotlin("jvm") version "2.0.0"
}

repositories {
    mavenCentral()
    // flatDir {
    //      dirs("lib")
    // }
    // flatDir {
    //      dirs("lib1", "lib2")
    // }
}

val lwjglVersion = "3.3.1"
val lwjglNatives = "natives-linux"

dependencies {
    // testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    // testImplementation(libs.junit.jupiter.engine)
    // testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // api(libs.commons.math3)
    // implementation(libs.guava)

    implementation(project(":tire:config"))

    implementation("org.lwjgl", "lwjgl", lwjglVersion)
    implementation("org.lwjgl", "lwjgl-glfw", lwjglVersion)
    implementation("org.lwjgl", "lwjgl-jemalloc", lwjglVersion)
    implementation("org.lwjgl", "lwjgl-opengl", lwjglVersion)
    implementation("org.lwjgl", "lwjgl-vulkan", lwjglVersion)
    runtimeOnly("org.lwjgl", "lwjgl", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-glfw", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-jemalloc", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-opengl", classifier = lwjglNatives)

    testImplementation(kotlin("test"))
    implementation("io.github.oshai:kotlin-logging-jvm:7.0.0")
}

tasks {
    test {
        useJUnitPlatform()

        testLogging.showStandardStreams = true

        testLogging {
            events("PASSED", "SKIPPED", "FAILED", "STANDARD_OUT", "STANDARD_ERROR")
        }
    }
}

