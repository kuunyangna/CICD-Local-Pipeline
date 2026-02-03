# Use Maven + JDK image
FROM maven:3.9.2-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn package -B

# Use lightweight Java runtime to run the jar
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/target/myapp.jar ./myapp.jar

EXPOSE 8080
CMD ["java", "-jar", "myapp.jar"]
