import denis.beck.dependencies.extensions.appModule
import kotlin.arrayOf
import denis.beck.dependencies.dependencies.Libs

appModule(
    dependencies = arrayOf(
        *Libs.compose,
        Libs.core,
        Libs.lifecycle,
        Libs.activityCompose,
        *Libs.junit,
        Libs.espressoCore,
    )
)