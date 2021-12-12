FROM maven:3.8.4-openjdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11.0-jdk
COPY --from=build "home/app/target/bloomtech-0.0.1-SNAPSHOT.jar" "bloomtech.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","bloomtech.jar"]