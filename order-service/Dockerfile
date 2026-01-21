# Use official OpenJDK
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first
COPY pom.xml .
RUN mkdir -p src && echo "// placeholder" > src/placeholder.txt
RUN mvn dependency:go-offline -B

# Copy project files
COPY . .

# Build the jar
RUN mvn clean package -DskipTests

# Run the jar
CMD ["java", "-jar", "target/user-service-0.0.1-SNAPSHOT.jar"]
