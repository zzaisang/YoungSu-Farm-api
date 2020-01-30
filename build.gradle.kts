import com.ewerk.gradle.plugins.tasks.QuerydslCompile

plugins {
	id("org.springframework.boot") version "2.1.7.RELEASE"
	java
	id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
}

group = "com.yongsu"
version = "0.0.1-SNAPSHOT"
apply(plugin = "io.spring.dependency-management")


configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_11
}
repositories {
	mavenCentral()

	jcenter()

}


val querydslSrcDir = "src-gen/main/java"

querydsl {
	library = "com.querydsl:querydsl-apt"
	jpa = true
	querydslSourcesDir = querydslSrcDir
}

tasks.getByName<QuerydslCompile>("compileQuerydsl") {
	options.annotationProcessorPath = configurations.getByName("querydsl")
}

configurations.getByName("querydsl") {
	extendsFrom(configurations.getByName("compileClasspath"))
}

sourceSets {
	getByName("main").java.srcDirs(listOf("src/main/java", querydslSrcDir))
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("com.querydsl:querydsl-jpa")
	annotationProcessor ("org.springframework.boot:spring-boot-configuration-processor")
	implementation("com.auth0:java-jwt:3.8.3")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude("org.junit.vintage:junit-vintage-engine")
	}
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	compileOnly("com.googlecode.json-simple:json-simple:1.1")
	implementation("org.apache.tika:tika-core:1.22")
	testCompile("org.projectlombok:lombok")
	testAnnotationProcessor("org.projectlombok:lombok")

	implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.5.7")
}

