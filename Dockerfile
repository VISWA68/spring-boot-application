# Build stage
FROM gradle:8.14.2-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean bootJar -x test

# Runtime stage
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/*SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
