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
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
    val composeSet = setOf(
        composeUi,
        composeMaterial,
        composePreview,
        activityCompose,
        viewModelCompose,
        navigationCompose
    )

    //lifecycle
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleSet = setOf(lifecycle, lifecycleViewModel)

    //jsoup
    const val jsoup = "org.jsoup:jsoup:${Versions.jsoup}"

    //hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    //retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    //gson
    const val gson = "com.google.code.gson:gson:${Versions.gson}"


}

fun DependencyHandler.implementation(dependencies: Collection<String>) {
    dependencies.forEach {
        add("implementation", it)
    }
}
