Для выполнения этой задачи я создал проект в IntelliJ IDEA, однако, чтобы не засорять репозиторий, я загрузил только исходный файл CoroutinesKt. На всякий случай оставляю здесь код для build.gradle.kts, который использовал для сборки проекта:

```gradle
plugins {
    kotlin("jvm") version "1.8.20"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("CoroutinesKt")
}
```