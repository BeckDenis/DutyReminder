val appModuleName = "app"
val dependenciesModuleName = "dependencies"
val modulesDirectoryName = "modules"
val gradlePathEnd = "/build.gradle.kts"
val generatedCode =
"""import denis.beck.dependencies.extensions.module
    
module()"""

rootProject.name = "DutyReminder"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

setUp()

fun Settings.setUp() {
    includeBuild("$rootDir/$dependenciesModuleName")
    setUpCore()
    setUpModules()
}

fun Settings.setUpCore() {
    rootDir.walkBottomUp()
        .maxDepth(1)
        .filter { it.absolutePath != rootDir.path && it.name != dependenciesModuleName }
        .handleModules()
        .findNameAndInclude()
}

fun Settings.setUpModules() {
    File(rootDir, modulesDirectoryName)
        .walkTopDown()
        .maxDepth(3)
        .findNameAndInclude()

}

fun Sequence<File>.findNameAndInclude() {
    filter { it.isDirectory && existDirectory(it) }
        .forEach { file ->
            val moduleName = ":${file.name}"
            include(moduleName)
            project(moduleName).projectDir = file(file.path)
            updateModulesNameFile(file.name)
        }
}

fun Sequence<File>.handleModules(): Sequence<File> {
    filter(::isModule).apply {
        forEach(::moveToModulesPackage)
        forEach(::clearSettingsGradle)
    }
    return this
}

fun moveToModulesPackage(file: File) {
    replaceDefaultGradle(File("$rootDir/${file.name}$gradlePathEnd"))
    file.renameTo(File("$rootDir/$modulesDirectoryName/${file.name}"))
}

fun replaceDefaultGradle(file: File) {
    val text = generatedCode
    file.bufferedWriter().use { it.write(text) }
}

fun isModule(file: File): Boolean {
    return file.name != appModuleName && file.isDirectory && existDirectory(file)
}

fun existDirectory(file: File): Boolean =
    File("${file.absolutePath}$gradlePathEnd").exists()

fun clearSettingsGradle(file: File) {
    val settings = File("$rootDir/settings.gradle.kts")
    var text = settings.inputStream().bufferedReader().use { it.readText() }
    val findText = "include(\":${file.name}\")"
    text = text.replace(findText, "").trimEnd()
    settings.bufferedWriter().use { it.write(text) }
}

fun updateModulesNameFile(name: String) {
    val dir = "dependencies/src/main/kotlin/denis/beck/dependencies"
    val modulesNames = File("$rootDir/$dir/ModulesName.kt")
    val text = modulesNames.inputStream().bufferedReader().use { it.readText() }
    if (!text.contains(name)) {
        modulesNames.bufferedWriter()
            .use { it.write("$text\nconst val $name = \":$name\"") }
    }
}
include(":mylibrary")
