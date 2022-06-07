package denis.beck.dependencies

import denis.beck.dependencies.configs.applyAppConfig
import denis.beck.dependencies.configs.applyCommonConfig
import denis.beck.dependencies.configs.applyLibraryConfig
import denis.beck.dependencies.extensions.app
import denis.beck.dependencies.extensions.library
import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            applyCommonConfig()
            app?.run {
                applyAppConfig()
            }
            library?.run {
                applyLibraryConfig()
            }
        }
    }
}