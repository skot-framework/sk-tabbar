plugins {
    id("java-library")
    kotlin("multiplatform")
    signing
}


kotlin {
    jvm("jvm")

    sourceSets {
        val jvmMain by getting {

            kotlin.srcDir("src/jvmMain/kotlin")

            dependencies {
                implementation(project(":viewmodel"))
                implementation("${Versions.frameworkGroup}:viewmodelTests:${Versions.framework}")
            }
        }
    }
}

if (!localPublication) {
    val publication = getPublication(project)

    val javadocJar by tasks.registering(Jar::class) {
        archiveClassifier.set("javadoc")
    }

    publishing {
        publications {
            publications.withType<MavenPublication> {
                artifact(javadocJar.get())

                pom {
                    name.set(project.name)
                    description.set("${project.name} description")
                    url.set("https://github.com/skot-framework/sk-tabbar")
                    licenses {
                        license {
                            name.set("Apache 2.0")
                            url.set("https://www.apache.org/licenses/LICENSE-2.0")
                        }
                    }
                    developers {
                        developer {
                            id.set("MathieuScotet")
                            name.set("Mathieu Scotet")
                            email.set("mscotet.lmit@gmail.com")
                        }
                    }
                    scm {
                        connection.set("scm:git:github.com/skot-framework/sk-tabbar.git")
                        developerConnection.set("scm:git:ssh://github.com/skot-framework/sk-tabbar.git")
                        url.set("https://github.com/skot-framework/sk-tabbar/tree/master")
                    }
                }
            }
        }

    }


    signing {
        useInMemoryPgpKeys(
                publication.signingKeyId,
                publication.signingKey,
                publication.signingPassword
        )
        this.sign(publishing.publications)
    }
}




