buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven {
            url = uri("https://jitpack.io")
        }
    }

    dependencies {
        classpath("com.github.MathieuScotet.skot:plugin:1.0.0-alpha46")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:1.5.30")
    }
}

allprojects {

    group = Versions.group
    version = Versions.version

    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
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
