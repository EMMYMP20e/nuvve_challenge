FROM maven:3.9.0-eclipse-temurin-17-alpine AS MAVEN_BUILD


COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package -DskipTests

FROM openjdk:17-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/demo-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]