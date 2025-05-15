# hello-world-android-lib

_Last updated 14-May-2025_

A minimal Android library that demonstrates building an `.aar` artifact locally and publishing it on [JitPack](https://jitpack.io) for easy consumption in other Android projects.

---

## Intent

This repository provides a simple “Hello World” Android library (`HelloLib`) which:

- Exposes a single class (`com.example.hellolib.HelloLib`) with a `sayHello()` method.
- Builds to an Android Archive (`.aar`) via Gradle.
- Leverages JitPack’s on-demand build service to publish and version your library by Git tags, branches, or commit hashes without manual Maven Central releases.

Use this as a template for your own Android libraries that you want to share quickly via Git repositories.

---

## Prerequisites

- **Java JDK 17+** installed and on your `PATH`.
- **Android SDK** installed. If building from the CLI, set in `local.properties`:

  ```properties
  sdk.dir=/Users/<your-user>/Library/Android/sdk
  ```

- **Git** repository hosted on GitHub (public or private—see JitPack for access details). See bare-bones example app at: https://github.com/jkoutavas/hello-world-android-app

---

## Project Structure

```
hello-world-android-lib/
├── gradle/…              # Gradle wrapper files
├── gradlew, gradlew.bat
├── settings.gradle.kts   # include(" :library")
├── build.gradle.kts      # root: repositories for all projects
├── library/              # Android library module
│   ├── build.gradle.kts  # Android & Kotlin plugin config
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           └── java/com/example/hellolib/HelloLib.kt
└── jitpack.yml           # (optional) JDK version for JitPack
```

---

## Building Locally

1. Make the Gradle wrapper executable:

   ```bash
   chmod +x gradlew
   ```

2. Assemble the release AAR:

   ```bash
   ./gradlew :library:assembleRelease
   ```

3. Find your library artifact at:

   ```
    library/build/outputs/aar/library-release.aar
   ```

You can then include this `.aar` directly in other Android projects under `libs/`, or upload it to any Maven repository.

---

## Publishing on JitPack

1. **Push** your code (including tags) to GitHub:

```bash
git add .
git commit -m "Initial library implementation"
git push origin main
git tag v1.0.0
git push origin v1.0.0
```

2. **Look up** your library on JitPack:

   - Go to [https://jitpack.io](https://jitpack.io)
   - Enter coordinates:

     ```text
     com.github.<GitHubUser>:hello-world-android-lib:v1.0.0
     ```

   - Click **Get It** and wait for the on-demand build to finish.

3. **Consume** in your Android project’s `build.gradle`:

   ```groovy
   repositories {
     maven { url 'https://jitpack.io' }
   }

   dependencies {
     implementation 'com.github.<GitHubUser>:hello-world-android-lib:v1.0.0'
   }
   ```

Optionally, include a **`jitpack.yml`** file at the repo root to lock your JDK version for consistent builds:

```yaml
jdk:
  - openjdk17
```

---

## Next Steps

- Bump `version` in `library/build.gradle.kts` and tag new releases.
- Extend your library with custom code, tests, and CI.
- Share private repositories by granting JitPack GitHub access or making them public.

Enjoy the zero-ceremony distribution of your Android libraries via JitPack! Feel free to fork and adapt this template.
