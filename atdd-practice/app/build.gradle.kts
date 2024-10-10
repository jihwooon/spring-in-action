plugins {
    java
    id("org.springframework.boot") version "3.3.4"
}

apply(plugin = "io.spring.dependency-management")

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {

    // Use Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Use Spring Boot Test
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.4")

    // Use Spring Boot Devtools
    implementation("org.springframework.boot:spring-boot-devtools:3.3.4")

}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
