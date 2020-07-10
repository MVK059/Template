import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"

    const val junit = "junit:junit:${Versions.JUNIT_VERSION}"
    const val testRunner = "androidx.test:runner:${Versions.TEST_RUNNER_VERSION}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_VERSION}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val retrofit_converter =
        "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_CONVERTER_VERSION}"
    const val ok_http = "com.squareup.okhttp3:okhttp:${Versions.OK_HTTP_VERSION}"
    const val ok_http_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OK_HTTP_VERSION}"
    const val retrofit_adapter =
        "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Versions.RETROFIT_ADAPTER_VERSION}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.ROOM_VERSION}"
    const val roomAnnotationProcessor = "androidx.room:room-compiler:${Versions.ROOM_VERSION}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.ROOM_VERSION}"

    const val kotlinSerialRuntime =
        "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.KOTLIN_SERIALIZATION_VERSION}"
    const val kotlinSerialConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.KOTLIN_SERIALIZATION_CONVERTER_VERSION}"

    const val lifecycleLiveDataKTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_VERSION}"
    const val lifecycleViewModelKTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
    const val lifecycleViewModel =
        "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX_VERSION}"

    const val epoxyCore = "com.airbnb.android:epoxy:${Versions.EPOXY_VERSION}"
    const val epoxyDataBinding = "com.airbnb.android:epoxy-databinding:${Versions.EPOXY_VERSION}"
    const val epoxyProcessor = "com.airbnb.android:epoxy-processor:${Versions.EPOXY_VERSION}"

    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE_VERSION}"

    const val transition = "androidx.transition:transition:${Versions.TRANSITION_VERSION}"

    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW_VERSION}"

    const val cardView = "androidx.cardview:cardview:${Versions.CARD_VIEW_VERSION}"

    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val androidXLegacySupport =
        "androidx.legacy:legacy-support-v4:${Versions.ANDROIDX_LEGACY_SUPPORT_VERSION}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.CORE_KTX_VERSION}"

    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.GRADLE_PLUGIN_VERSION}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_VERSION}"
    const val kotlinSerializationPlugin =
        "org.jetbrains.kotlin:kotlin-serialization:${Versions.KOTLIN_VERSION}"

    const val hilt_dagger_main =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.DAGGER_HILT_VERSION}"
    const val hilt_dagger = "com.google.dagger:hilt-android:${Versions.DAGGER_HILT_VERSION}"
    const val hilt_dagger_compiler =
        "com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT_VERSION}"
    const val hilt_dagger_vm =
        "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.DAGGER_HILT_LIFECYCLE_VERSION}"
    const val hilt_dagger_vm_compiler =
        "androidx.hilt:hilt-compiler:${Versions.DAGGER_HILT_LIFECYCLE_VERSION}"

    const val dagger = "com.google.dagger:dagger:${Versions.DAGGER_VERSION}"
    const val dagger_compiler =
        "com.google.dagger:dagger-compiler:${Versions.DAGGER_VERSION}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.GLIDE_VERSION}"
    const val glide_compiler =
        "com.github.bumptech.glide:compiler:${Versions.GLIDE_COMPILER_VERSION}"

    const val timber = "com.jakewharton.timber:timber:${Versions.TIMBER_VERSION}"
    const val gson = "com.google.code.gson:gson:${Versions.GSON_VERSION}"

    const val rx_java = "io.reactivex.rxjava2:rxjava:${Versions.RX_JAVA_VERSION}"
    const val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.RX_ANDROID_VERSION}"

    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_VERSION}"

}

fun DependencyHandler.appCompat() {
    implementation(Dependencies.appCompat)
    implementation(Dependencies.androidXLegacySupport)
    implementation(Dependencies.coreKtx)
}

fun DependencyHandler.epoxy() {
    implementation(Dependencies.epoxyCore)
    implementation(Dependencies.epoxyDataBinding)
    kapt(Dependencies.epoxyProcessor)
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomAnnotationProcessor)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofit_converter)
    implementation(Dependencies.ok_http)
    implementation(Dependencies.ok_http_interceptor)
    implementation(Dependencies.retrofit_adapter)
}

fun DependencyHandler.lifecycle() {
    implementation(Dependencies.lifecycleLiveDataKTX)
    implementation(Dependencies.lifecycleViewModelKTX)
    implementation(Dependencies.lifecycleViewModel)

}

fun DependencyHandler.kotlinSerialization() {
    implementation(Dependencies.kotlinSerialRuntime)
    implementation(Dependencies.kotlinSerialConverter)
}

fun DependencyHandler.defaultTests() {
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.testRunner)
    androidTestImplementation(Dependencies.espresso)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hilt_dagger)
    implementation(Dependencies.hilt_dagger_vm)
    implementation(Dependencies.dagger)
    kapt(Dependencies.hilt_dagger_compiler)
    kapt(Dependencies.hilt_dagger_vm_compiler)
    kapt(Dependencies.dagger_compiler)
}

fun DependencyHandler.glide() {
    implementation(Dependencies.glide)
    kapt(Dependencies.glide_compiler)
}

fun DependencyHandler.rxjava() {
    implementation(Dependencies.rx_java)
    implementation(Dependencies.rx_android)
}

private fun DependencyHandler.implementation(dep: String) {
    add("implementation", dep)
}

private fun DependencyHandler.kapt(dep: String) {
    add("kapt", dep)
}

private fun DependencyHandler.androidTestImplementation(dep: String) {
    add("androidTestImplementation", dep)
}

private fun DependencyHandler.testImplementation(dep: String) {
    add("testImplementation", dep)
}