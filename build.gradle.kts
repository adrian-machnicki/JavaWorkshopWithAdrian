plugins {
    id("java")
    id("idea")
}

group = "com.workshop"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    implementation("com.opencsv:opencsv:5.6")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}