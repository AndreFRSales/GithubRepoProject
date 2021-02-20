object MaterialDesignVersions {
    const val appCompatVersion = "1.2.0"
    const val recyclerViewVersion = "1.1.0"
    const val constraintLayoutVersion = "2.0.4"
    const val materialDesignVersion = "1.3.0"
}

object MaterialDesign {
    const val appComponent =
        "androidx.appcompat:appcompat:${MaterialDesignVersions.appCompatVersion}"
    const val recyclerView =
        "androidx.recyclerview:recyclerview:${MaterialDesignVersions.recyclerViewVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${MaterialDesignVersions.constraintLayoutVersion}"
    const val materialDesign =
        "com.google.android.material:material:${MaterialDesignVersions.materialDesignVersion}"
}

object AndroidFrameworkVersions {
    const val kotlinCoreVersion = "1.3.2"
}

object AndroidFramework {
    const val kotlinCore = "androidx.core:core-ktx:${AndroidFrameworkVersions.kotlinCoreVersion}"
}

object KotlinVersions {
    const val kotlinVersion = "1.4.30"
    const val kotlinSerialization = "1.1.0"
}

object Kotlin {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${KotlinVersions.kotlinVersion}"
    const val kotlinSerialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${KotlinVersions.kotlinSerialization}"
}

object JetpackVersions {
    const val lifecycle = "2.2.0"
    const val navigation = "2.3.0"
}

object Jetpack {
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${JetpackVersions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${JetpackVersions.lifecycle}"
    const val runtime = "androidx.lifecycle:lifecycle-runtime:${JetpackVersions.lifecycle}"
    const val common = "androidx.lifecycle:lifecycle-common-java8:${JetpackVersions.lifecycle}"
    const val savedStateViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${JetpackVersions.lifecycle}"
    const val navigation = "androidx.navigation:navigation-ui-ktx:${JetpackVersions.navigation}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${JetpackVersions.navigation}"
    const val navigationSafeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${JetpackVersions.navigation}"

}

object Coroutines {
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${CoroutinesVersions.coroutineVersion}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoroutinesVersions.coroutineVersion}"
    const val coroutineTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${CoroutinesVersions.coroutineVersion}"
}

object CoroutinesVersions {
    const val coroutineVersion = "1.3.5"
}

object KoinVersions {
    const val koinVersion = "2.1.5"
}

object Koin {
    const val koin = "org.koin:koin-android:${KoinVersions.koinVersion}"
    const val lifecycleKoin = "org.koin:koin-androidx-scope:${KoinVersions.koinVersion}"
    const val viewModelKoin = "org.koin:koin-androidx-viewmodel:${KoinVersions.koinVersion}"
}

object NetworkVersions {
    const val retrofit2Version = "2.9.0"
    const val kotlinSerializationAdapterVersion = "0.8.0"
    const val okHttpVersion = "4.9.0"
}

object Network {
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${NetworkVersions.retrofit2Version}"
    const val kotlinSerializationAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${NetworkVersions.kotlinSerializationAdapterVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${NetworkVersions.okHttpVersion}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${NetworkVersions.okHttpVersion}"
}


object TestDependenciesVersion {
    const val junitVersion = "4.12"
    const val junitAndroidVersion = "1.1.1"
    const val robolectricVersion = "4.3.1"
    const val espressoVersion = "3.2.0"
    const val testRunnerVersion = "1.2.0"
    const val archCore = "2.1.0"
    const val mockK = "1.10.0"
}

object TestDependencies {
    const val junit = "junit:junit:${TestDependenciesVersion.junitVersion}"
    const val junitAndroid =
        "androidx.test.ext:junit:${TestDependenciesVersion.junitAndroidVersion}"
    const val robolectric =
        "org.robolectric:robolectric:${TestDependenciesVersion.robolectricVersion}"
    const val espresso =
        "androidx.test.espresso:espresso-core:${TestDependenciesVersion.espressoVersion}"
    const val testRunner = "androidx.test:runner:${TestDependenciesVersion.testRunnerVersion}"
    const val archTest = "androidx.arch.core:core-testing:${TestDependenciesVersion.archCore}"
    const val mockK = "io.mockk:mockk:${TestDependenciesVersion.mockK}"
}

