package denis.beck.dependencies.configs

import denis.beck.dependencies.extensions.base
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

private val javaVersion = JavaVersion.VERSION_11

fun Project.applyCommonConfig() {
    addPlugins()
    setSdkVersions()
    setRepositories()
    setKotlinOption()
    setCompileOptions()
}

private fun Project.addPlugins() {
    plugins.apply("kotlin-android")
    plugins.apply("kotlin-kapt")
}

private fun Project.setSdkVersions() {
    base?.run {
        compileSdkVersion(32)
        defaultConfig {
            targetSdk = 32
            minSdk = 22
        }
    }
}

private fun Project.setRepositories() {
    repositories {
        google()
        mavenCentral()
    }
}

private fun Project.setKotlinOption() {
    this.tasks.withType<KotlinCompile<KotlinJvmOptions>> {
        kotlinOptions {
            jvmTarget = "$javaVersion"
        }
    }
}

private fun Project.setCompileOptions() {
    base?.run {
        compileOptions {
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }
    }
}
