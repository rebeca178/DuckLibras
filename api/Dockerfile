FROM eclipse-temurin:24-jdk-alpine AS gradle-base
RUN apk add --no-cache bash curl zip unzip
RUN curl -s https://downloads.gradle-dn.com/distributions/gradle-8.1.2-bin.zip -o gradle.zip && \
    unzip gradle.zip -d /opt && \
    rm gradle.zip && \
    ln -s /opt/gradle-8.1.2/bin/gradle /usr/bin/gradle

# Etapa de build
FROM gradle-base AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle build -x test --stacktrace --info

# Etapa de execução
FROM eclipse-temurin:24-jdk-alpine
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
