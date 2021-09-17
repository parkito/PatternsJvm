buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    java
    kotlin("jvm") version "1.5.30"
}

allprojects {
    group = "org.example"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }

}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("java")
        plugin("kotlin")
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.30")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    }
}