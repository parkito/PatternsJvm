val kotlinVersion: String by project
val jupiter5Version: String by project

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    java
    kotlin("jvm") version "1.5.31"
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
        implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
        testImplementation("org.junit.jupiter:junit-jupiter-api:$jupiter5Version")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jupiter5Version")
    }

    tasks.test {
        useJUnitPlatform()
    }
}
