# Use an official OpenJDK runtime as the base image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory in the container
WORKDIR /app
ARG JAR_FILE=target/*.jar
# Copy the JAR file into the container
COPY ./target/SpotifyAPI-0.0.2.jar app.jar

# Expose the port your Spring Boot application is listening on
EXPOSE 8080

# Set the entry point command to run the Spring Boot application
CMD ["java", "-jar", "/app.jar"]