buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        mavenLocal()
    }

    dependencies {
        classpath("tech.skot:plugin:1.0.0-alpha13")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("http://raw.github.com/MathieuScotet/skot/repository")
        }
        maven {
            url = uri("https://jitpack.io")
        }
    }

}
