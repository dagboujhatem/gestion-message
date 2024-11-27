# Stage 1: Build the application
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


# Stage 2: Create the runtime container
FROM openjdk:17-jdk-slim
# Create a non-root user
RUN useradd -m -s /bin/bash webadm
WORKDIR /app
COPY --from=build target/gestion-message.jar app.jar
# Set permissions for the non-root user
RUN chown -R webadm:webadm /app && chmod 755 /app
# Switch to the non-root user
USER webadm
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
