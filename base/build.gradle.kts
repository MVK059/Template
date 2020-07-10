plugins {
    id("com.android.library")
    id("kotlinx-serialization")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
}


android {
    compileSdkVersion(Application.COMPILE_SDK_VERSION)
    buildToolsVersion = Versions.BUILD_TOOLS_VERSION


    defaultConfig {
        minSdkVersion(Application.MIN_SDK_VERSION)
        targetSdkVersion(Application.TARGET_SDK_VERSION)
        versionCode = Application.VERSION_CODE
        versionName = Application.VERSION_NAME

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "API_KEY", "\"\"")
            buildConfigField("String", "BASE_URL", "\"\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            buildConfigField("String", "API_KEY", "\"\"")
            buildConfigField("String", "BASE_URL", "\"\"")
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
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

    implementation(project(":network"))

    implementation(Dependencies.kotlin)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.coroutines)
    implementation(Dependencies.recyclerView)
    implementation(Dependencies.timber)
    implementation(Dependencies.gson)

    appCompat()
    defaultTests()
    kotlinSerialization()
    lifecycle()
    room()
    hilt()
    rxjava()
    glide()

}
