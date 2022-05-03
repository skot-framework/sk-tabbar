buildscript {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        classpath("tech.skot:plugin:${Versions.framework}")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:1.5.30")
    }
}

plugins {
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

allprojects {

    group = Versions.group
    version = "${Versions.library}_${Versions.framework}"

    repositories {
        google()
        mavenLocal()
        mavenCentral()
    }

    apply(plugin = "maven-publish")
    apply(plugin = "org.jetbrains.dokka")

}

subprojects{
    tasks {
        named<org.jetbrains.dokka.gradle.DokkaTaskPartial>("dokkaHtmlPartial") {
            suppressInheritedMembers.set(true)
        }
        named<org.jetbrains.dokka.gradle.DokkaTaskPartial>("dokkaGfmPartial") {
            suppressInheritedMembers.set(true)
        }
    }
}
if(!localPublication) {
    val publication = getPublication(project)

    nexusPublishing {
        repositories {
            sonatype {
                stagingProfileId.set(publication.sonatypeStagingProfileId)
                username.set(publication.ossrhUsername)
                password.set(publication.ossrhPassword)
                nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
                snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            }
        }
    }
}
