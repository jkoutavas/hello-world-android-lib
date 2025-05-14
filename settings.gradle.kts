pluginManagement {
  repositories {
    // order matters: check Gradle Plugin Portal, then Google’s repo, then Maven Central
    gradlePluginPortal()
    google()
    mavenCentral()
  }
}

rootProject.name = "hello-world-android-lib"
include(":library")