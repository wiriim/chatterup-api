FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests



FROM eclipse-temurin:17-jre

WORKDIR /app

ARG JAR_FILE=/app/target/*.jar

COPY --from=build ${JAR_FILE} app.jar

EXPOSE 8000

ENTRYPOINT ["java","-jar","/app/app.jar"]