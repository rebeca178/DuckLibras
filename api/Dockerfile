FROM gradle:8.12.1-jdk23-alpine AS build

WORKDIR /home/gradle/src

COPY --chown=gradle:gradle . /home/gradle/src

RUN gradle build -x test

FROM eclipse-temurin:23-jdk-alpine

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-jar", "/app/spring-boot-application.jar"]
