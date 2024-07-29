
plugins {
    kotlin("multiplatform") version "2.0.0"
}

kotlin {
    linuxX64("bin") {
        binaries {
            executable()
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "8.9"
    distributionType = Wrapper.DistributionType.BIN
}
