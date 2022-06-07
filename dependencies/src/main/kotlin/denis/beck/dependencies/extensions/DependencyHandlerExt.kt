package denis.beck.dependencies.extensions

import denis.beck.dependencies.dependencies.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.add(dependency: Dependency) =
    this.add(dependency.configuration, dependency.notation)

fun DependencyHandler.implementation(dependencyNotation: Any) =
    this.add("implementation", dependencyNotation)