plugins {
    id("com.android.application")
    id("kotlinx-serialization")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Application.COMPILE_SDK_VERSION)
    buildToolsVersion = Versions.BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId = AppCoordinates.APP_ID
        minSdkVersion(Application.MIN_SDK_VERSION)
        targetSdkVersion(Application.TARGET_SDK_VERSION)
        versionCode = Application.VERSION_CODE
        versionName = Application.VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = true
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

    // For Kotlin projects
    kotlinOptions {
        jvmTarget = "1.8"
    }

    dataBinding {
        isEnabled = true
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":base"))
    implementation(project(":network"))
    implementation(project(":database"))

    // Individual dependencies
    implementation(Dependencies.kotlin)
    implementation(Dependencies.coroutines)
    implementation(Dependencies.transition)
    implementation(Dependencies.recyclerView)
    implementation(Dependencies.cardView)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.timber)
    implementation(Dependencies.gson)

    // Groups of dependencies
    appCompat()
    epoxy()
    defaultTests()
    lifecycle()
    room()
    retrofit()
    hilt()
    glide()
    rxjava()
}
