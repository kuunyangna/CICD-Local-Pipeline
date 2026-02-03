FROM maven:3.9.2-eclipse-temurin-17 AS build

WORKDIR /app

# Copy everything
COPY pom.xml .
COPY WebApp.java .
COPY index.html .

# Build jar manually
RUN mvn dependency:go-offline -B
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app
COPY --from=build /app/target/*.jar ./app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
