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
        classpath("com.github.MathieuScotet.skot:plugin:1.0.0-alpha44")
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

}
