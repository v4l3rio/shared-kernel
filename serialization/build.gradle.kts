plugins {
    id("java")
    id("com.github.davidmc24.gradle.plugin.avro") version "1.9.1"
}

group = "io.github.positionpal"
version = "0.1.0-archeo+575938"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.apache.avro:avro:1.12.0")
}

tasks.test {
    useJUnitPlatform()
}
