plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // Annotation Processor NEW
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.krillinator.lektion_11_roomdb"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.krillinator.lektion_11_roomdb"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }

}



dependencies {

    // Room DB
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    androidTestImplementation("androidx.room:room-testing:2.6.1")

    // To use Kotlin annotation processing tool (kapt)
    // ksp("androidx.room:room-compiler:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")

    // LifeCycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}