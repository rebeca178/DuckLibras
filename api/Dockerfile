# Etapa de build
FROM gradle AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle build

# Etapa de execução
FROM eclipse-temurin:24-jdk-alpine
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
