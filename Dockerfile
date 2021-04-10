FROM maven:3.6.1-jdk-13-alpine AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package -Dmaven.test.skip=true -e
FROM openjdk:13-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/jsontoxml-0.0.1-SNAPSHOT.jar /app/

EXPOSE 5656
ENTRYPOINT ["java", "-jar", "jsontoxml-0.0.1-SNAPSHOT.jar"]