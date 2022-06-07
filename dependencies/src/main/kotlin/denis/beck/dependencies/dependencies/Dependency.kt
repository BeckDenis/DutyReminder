package denis.beck.dependencies.dependencies

data class Dependency (val configuration: String, val notation: String)

val String.impl: Dependency get() = Dependency("implementation", this)
val String.testImpl: Dependency get() = Dependency("testImplementation", this)
val String.androidTestImpl: Dependency
    get() = Dependency("androidTestImplementation", this)
val String.debugImpl: Dependency get() = Dependency("debugImplementation", this)