package denis.beck.dependencies.dependencies

object Libs {

    val compose = arrayOf(
        "androidx.compose.ui:ui:${LibVersions.compose}".impl,
        "androidx.compose.material:material:${LibVersions.compose}".impl,
        "androidx.compose.ui:ui-tooling-preview:${LibVersions.compose}".impl,
        "androidx.compose.ui:ui-tooling:${LibVersions.compose}".debugImpl,
        "androidx.compose.ui:ui-test-manifest:${LibVersions.compose}".debugImpl,
        "androidx.compose.ui:ui-test-junit4:${LibVersions.compose}".androidTestImpl,
    )

    val core = "androidx.core:core-ktx:1.8.0".impl

    val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1".impl

    val activityCompose = "androidx.activity:activity-compose:1.4.0".impl


    val junit = arrayOf(
        "junit:junit:4.13.2".testImpl,
        "androidx.test.ext:junit:1.1.3".androidTestImpl
    )

    val espressoCore = "androidx.test.espresso:espresso-core:3.4.0".androidTestImpl

}

