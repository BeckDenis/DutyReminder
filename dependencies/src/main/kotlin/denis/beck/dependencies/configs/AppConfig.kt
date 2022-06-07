package denis.beck.dependencies.configs

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import denis.beck.dependencies.dependencies.LibVersions

@Suppress("UnstableApiUsage")
internal fun BaseAppModuleExtension.applyAppConfig() {
    defaultConfig {
        applicationId = "denis.beck.dutyreminder"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = LibVersions.compose
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}