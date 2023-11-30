# Use the official Maven image as a base image
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file (pom.xml) and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code to the container
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use a lightweight base image for the application
FROM adoptopenjdk/openjdk17:alpine-jre

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage to the container
COPY --from=build /app/target/topten.jar ./app.jar

# Expose the port your Spring Boot application uses (usually 8080)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
