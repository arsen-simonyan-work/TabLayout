import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.jvm") version "1.8.20" apply false
    id("org.jetbrains.compose") version "1.5.0-dev1036"
}

group = "com.example"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)

                implementation(compose.desktop.currentOs)
                //implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha08")
                //implementation("io.coil-kt:coil-compose:2.3.0")
                //implementation("androidx.compose.foundation:foundation-layout:1.1.0")
                implementation("androidx.navigation:navigation-compose:2.5.3")
                implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "TabLayout"
            packageVersion = "1.0.0"
        }
    }
}
