plugins {
  id("com.android.library") version "8.2.1"
  id("org.jetbrains.kotlin.android") version "2.0.21"
}

android {
  compileSdk = 34

  defaultConfig {
    minSdk = 21
    version = "1.0.0"
  }

  // Make sure Java compilation targets 1.8
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  // And make Kotlin emit 1.8 bytecode
  kotlinOptions {
    jvmTarget = "1.8"
  }

  namespace = "com.example.hellolib"
}

// (Optional redundancy—ensures any KotlinCompile task is correct)
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

tasks.withType<Jar>().configureEach {
  if (archiveClassifier.get() == "sources") {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
  }
}