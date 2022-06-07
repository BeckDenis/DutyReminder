buildscript {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://maven.google.com") }
        gradlePluginPortal()
    }
    dependencies {
        classpath("denis.beck.dependencies:dependencies:SNAPSHOT")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    kotlin("android") version "1.6.21" apply false
    id("com.android.application") version "7.2.0" apply false
    id("com.android.library") version "7.2.0" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://maven.google.com") }
    }
}

subprojects {
    buildscript {
        repositories {
            google()
            mavenCentral()
            maven { setUrl("https://maven.google.com") }
        }
    }
}
