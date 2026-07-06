plugins {
    kotlin("jvm") version "2.4.0"
}

// The released Vár version from Maven Central.
val varVersion = "0.3.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("com.oselvar:var-kotlin:$varVersion")
    // Brings the Kotest JUnit Platform runner transitively (VarSpec extends FunSpec).
    testImplementation("com.oselvar:var-kotest:$varVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.1.1")
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
