plugins {
    kotlin("multiplatform")
    id("tech.skot.library-contract")
    signing
}


val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

if (!localPublication) {
    val publication = getPublication(project)
    publishing {
        publications.withType<MavenPublication> {
            artifact(javadocJar.get())

            pom {
                name.set(project.name)
                description.set("${project.name} module for SK-Tabbar skot library")
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
                    developer {
                        id.set("sgueniot")
                        name.set("Sylvain Guéniot")
                        email.set("sylvain.gueniot@gmail.com")
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

    signing {
        useInMemoryPgpKeys(
            publication.signingKeyId,
            publication.signingKey,
            publication.signingPassword
        )
        this.sign(publishing.publications)
    }
}