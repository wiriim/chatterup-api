FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
RUN echo "=== BUILD ==="
RUN echo "PATH=$PATH"
RUN which java
RUN java -version
WORKDIR /app
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="${JAVA_HOME}/bin:${PATH}"
ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
ENTRYPOINT ["/opt/java/openjdk/bin/java", "-jar", "/app/app.jar"]