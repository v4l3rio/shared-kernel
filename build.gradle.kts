import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.kotlin.dokka)
    alias(libs.plugins.git.semantic.versioning)
    alias(libs.plugins.publish)
}

allprojects {
    group = "io.github.positionpal"

    repositories {
        mavenCentral()
    }
}

inner class ProjectInfo {
    val repoOwner = "position-pal"
    val longName = "Common code for PositionPal"
    val description = "Library contains common code useful in PositionPal organization"
    val website = "https://github.com/$repoOwner/$name"
    val vcsUrl = "$website.git"
    val scm = "scm:git:$website.git"
}
val projectInfo = ProjectInfo()

publishOnCentral {
    projectLongName = projectInfo.longName
    projectDescription = projectInfo.description
    projectUrl = projectInfo.website
    scmConnection = projectInfo.scm
    licenseName = "Apache License, Version 2.0"
    licenseUrl = "https://www.apache.org/licenses/LICENSE-2.0"
    repoOwner = projectInfo.repoOwner
    repository("https://maven.pkg.github.com/${projectInfo.repoOwner}/$name", "GitHub") {
        user = repoOwner
        password = System.getenv("GITHUB_TOKEN")
    }
    publishing {
        publications {
            withType<MavenPublication> {
                pom {
                    developers {
                        developer {
                            name = "Luca Tassinari"
                            email = "luca.tassinari.2000@gmail.com"
                        }
                        developer {
                            name = "Valerio Di Zio"
                            email = "diziovalerio@gmail.com"
                        }
                        developer {
                            name = "Giovanni Antonioni"
                            email = ""
                        }
                    }
                }
            }
        }
    }
}
signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
}

subprojects {

    with(rootProject.libs.plugins) {
        apply(plugin = kotlin.jvm.get().pluginId)
        apply(plugin = kotlin.qa.get().pluginId)
        apply(plugin = kotlin.dokka.get().pluginId)
    }

    with(rootProject.libs) {
        dependencies {
            implementation(kotlin.stdlib)
            implementation(kotlin.stdlib.jdk8)
            testImplementation(bundles.kotlin.testing)
        }
    }

    kotlin {
        compilerOptions {
            allWarningsAsErrors = true
        }
    }

    tasks.withType<Test>().configureEach {
        testLogging {
            events(*TestLogEvent.values())
            exceptionFormat = TestExceptionFormat.FULL
        }
        useJUnitPlatform()
    }
}
