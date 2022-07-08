import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependency {
    //core
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    //compose
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    val composeSet = setOf(
        composeUi, composeMaterial, composePreview, activityCompose, viewModelCompose
    )

    //lifecycle
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleSet = setOf(lifecycle, lifecycleViewModel)

}

fun DependencyHandler.implementation(dependencies: Collection<String>) {
    dependencies.forEach {
        add("implementation", it)
    }
}
