
plugins {
    kotlin("jvm") version "2.0.0"
}

dependencies {
    // testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    // testImplementation(libs.junit.jupiter.engine)
    // testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // api(libs.commons.math3)
    // implementation(libs.guava)

    testImplementation(kotlin("test"))
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

//repositories {
//    flatDir {
//        dirs("lib")
//    }
//    flatDir {
//        dirs("lib1", "lib2")
//    }

