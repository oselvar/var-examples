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
    testImplementation("com.oselvar:var-junit:$varVersion")
    testImplementation(platform("org.junit:junit-bom:6.1.1"))
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
