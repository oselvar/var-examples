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
    // Brings the Kotest JUnit Platform runner transitively (VarSpec extends FunSpec).
    testImplementation("dev.varar:kotest:$varVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.1.2")
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
