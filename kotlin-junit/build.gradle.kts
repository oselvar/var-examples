plugins {
    kotlin("jvm") version "2.4.0"
}

// The released Varar version from Maven Central.
val varVersion = "0.6.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("dev.varar:kotlin:$varVersion")
    testImplementation("dev.varar:junit:$varVersion")
    testImplementation(platform("org.junit:junit-bom:6.1.2"))
    testImplementation("org.junit.platform:junit-platform-suite")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
