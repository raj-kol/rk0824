plugins {
    id("java")
}

group = "com.hd"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.2")
    implementation("com.google.guava:guava:33.2.1-jre")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework:spring-test:6.1.11")

}

tasks.test {
    useJUnitPlatform()
}