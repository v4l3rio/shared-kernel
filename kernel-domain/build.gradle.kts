plugins {
    id("java")
}

group = "io.github.positionpal"
version = "0.5.1-dev01+a3b1167"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.11.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
