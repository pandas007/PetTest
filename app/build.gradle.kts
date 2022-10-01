plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

val compose_version = "1.3.1"

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.pandasby.pettest"
        minSdk = 23
        targetSdk = 32
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = compose_version
    }
}

dependencies {

    implementation(Dependency.coreKtx)
    implementation(Dependency.composeSet)
    implementation(Dependency.lifecycleSet)
    implementation(Dependency.gson)
    implementation(Dependency.retrofitSet)
    implementation(Dependency.okhttpLogging)
    implementation(Dependency.hilt)
    kapt(Dependency.hiltCompiler)

    debugImplementation(Dependency.composePreviewDebug)
}