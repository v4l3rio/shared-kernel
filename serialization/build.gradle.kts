plugins {
    alias(libs.plugins.avro)
}

dependencies {
    with(libs) {
        testImplementation(platform(bom.junit))
        testImplementation(junit.jupiter)
        implementation(avro)
    }
}
