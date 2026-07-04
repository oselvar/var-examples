plugins {
    java
}

// The released Vár version from Maven Central.
val varVersion = "0.3.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("com.oselvar:var-junit:$varVersion")
    testImplementation(platform("org.junit:junit-bom:6.1.1"))
    // Gradle only discovers class-based tests, so the sample uses a JUnit
    // @Suite (see RunVarSpecsTest) to hand the spec corpus to the "var" engine.
    testImplementation("org.junit.platform:junit-platform-suite")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
