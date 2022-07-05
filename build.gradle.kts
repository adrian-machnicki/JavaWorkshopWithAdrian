plugins {
    id("java")
    id("idea")
}

group = "com.workshop.employeesapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.opencsv:opencsv:5.6")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("org.mockito:mockito-junit-jupiter:4.6.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}