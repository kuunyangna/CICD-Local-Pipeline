# Stage 1: Build the Java app using Maven + JDK
FROM maven:3.9.2-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml first to download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build the jar
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Run app using lightweight JRE
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the jar from build stage
COPY --from=build /app/target/*.jar ./app.jar

# Expose the app port (adjust if needed)
EXPOSE 8080

# Start the app
CMD ["java", "-jar", "app.jar"]
