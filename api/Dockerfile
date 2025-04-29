# Etapa de build
FROM gradle:7.6.1-jdk24 AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle build -x 

# Etapa de execução
FROM eclipse-temurin:24-jdk-alpine
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
