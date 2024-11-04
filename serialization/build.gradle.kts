plugins {
    id("java")
    alias(libs.plugins.avro)
}

group = "io.github.positionpal"
version = "0.1.0-archeo+575938"

repositories {
    mavenCentral()
}

dependencies {
    with(libs) {
        testImplementation(platform(bom.junit))
        testImplementation(junit.jupiter)
        implementation(avro)
    }
}

tasks.test {
    useJUnitPlatform()
}
