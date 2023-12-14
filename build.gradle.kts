plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = ""

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "unscramble.MainKt"
    }
    archiveBaseName = "unscramble"
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}