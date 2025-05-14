plugins {
  id("com.android.library")
  kotlin("android")
}

android {
  compileSdk = 34

  defaultConfig {
    minSdk = 21
    targetSdk = 34
    version = "1.0.0"
  }

  namespace = "com.example.hellolib"
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib")
}