plugins {
    `kotlin-dsl`
}

group = "denis.beck.dependencies"
version = "SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

gradlePlugin {
    plugins {
        register("dependencies") {
            id = "dependencies"
            implementationClass = "denis.beck.dependencies.DependenciesPlugin"
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())
    implementation(kotlin("gradle-plugin", "1.6.21"))
    implementation(kotlin("android-extensions"))
    implementation("com.android.tools.build:gradle:7.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}