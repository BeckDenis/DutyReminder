package denis.beck.dependencies.configs

import com.android.build.gradle.LibraryExtension

@Suppress("UnstableApiUsage")
internal fun LibraryExtension.applyLibraryConfig() {
    defaultConfig {
        consumerProguardFiles("proguard-rules.pro")
    }

    buildTypes {
        findByName("release")?.apply {
            isMinifyEnabled = false
        }
    }
}