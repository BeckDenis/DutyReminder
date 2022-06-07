package denis.beck.dependencies.extensions

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import denis.beck.dependencies.dependencies.Dependency
import org.gradle.api.Project

private val applicationPlugins = listOf(
    "com.android.application",
    "org.jetbrains.kotlin.android"
)
private const val libraryPlugin = "com.android.library"
private val commonPlugins = listOf("dependencies")

fun Project.appModule(
    plugins: Array<String> = emptyArray(),
    modules: Array<String> = emptyArray(),
    dependencies: Array<Dependency> = emptyArray(),
) = this.base(
    plugins = plugins + applicationPlugins,
    modules = modules,
    dependencies = dependencies,
)

fun Project.module(
    plugins: Array<String> = emptyArray(),
    modules: Array<String> = emptyArray(),
    dependencies: Array<Dependency> = emptyArray(),
) = this.base(
    plugins = plugins + libraryPlugin,
    modules = modules,
    dependencies = dependencies,
)

private fun Project.base(
    plugins: Array<String> = emptyArray(),
    modules: Array<String> = emptyArray(),
    dependencies: Array<Dependency> = emptyArray(),
) {
    (plugins + commonPlugins).forEach(this.plugins::apply)
    modules.map(::project).forEach(this.dependencies::implementation)
    dependencies.forEach(this.dependencies::add)
}

val Project.base: BaseExtension?
    get() = android as? BaseExtension

val Project.app: BaseAppModuleExtension?
    get() = android as? BaseAppModuleExtension

val Project.library: LibraryExtension?
    get() = android as? LibraryExtension

private val Project.android get() = extensions.findByName("android")
