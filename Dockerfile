# Start from an OpenJDK 21 image
FROM openjdk:21-jdk-slim AS build

# Install Maven 3.9.2 manually
RUN apt-get update && apt-get install -y curl && \
    curl -sSL https://archive.apache.org/dist/maven/maven-3/3.9.2/binaries/apache-maven-3.9.2-bin.tar.gz | tar xz -C /opt && \
    ln -s /opt/apache-maven-3.9.2/bin/mvn /usr/local/bin/mvn

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code to the container
COPY . /app

# Specify the default profile in the Dockerfile
ENV SPRING_PROFILES_ACTIVE=prod

# Run Maven to build the JAR files (both order-service and product-service)
RUN mvn clean install -DskipTests

# Now use a smaller OpenJDK base image for running the application
FROM openjdk:21-jdk-slim


# Copy the generated JAR files from the build stage
COPY --from=build /app/target/blog-app-apis.jar /app/blog-app-apis.jar

# Expose the required ports for services
EXPOSE 8081

CMD ["java", "-jar", "/app/blog-app-apis.jar"]

