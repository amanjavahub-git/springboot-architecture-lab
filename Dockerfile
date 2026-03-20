# Line 1: Use base image with JDK
FROM openjdk:17-jdk-slim

# Line 2: Set working directory inside container
WORKDIR /app

# Line 3: Copy built JAR into container
COPY target/springboot-architecture-lab-0.0.1-SNAPSHOT.jar app.jar

# Line 4: Expose Spring Boot default port
EXPOSE 8080

# Line 5: Create a directory for persistent data
VOLUME /app/data

# Line 6: Run the JAR
ENTRYPOINT ["java","-jar","app.jar"]
