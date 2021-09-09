buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }

    dependencies {
        classpath("tech.skot:plugin:1.0.0-alpha30")
    }
}

allprojects {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("https://raw.github.com/MathieuScotet/skot/repository")
            credentials {
                username = "MathieuScotet"
                password = "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"
            }
        }
        maven {
            url = uri("https://jitpack.io")
        }
    }

    apply(plugin = "maven-publish")

    configure<PublishingExtension> {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/MathieuScotet/skot")
                val gihubpackages_username: String by project
                val gihubpackages_publishtoken: String by project
                credentials {
                    username = gihubpackages_username
                    password = gihubpackages_publishtoken
                }
            }
        }
    }

}
