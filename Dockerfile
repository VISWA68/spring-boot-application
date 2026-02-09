# Build stage
FROM gradle:8.14.2-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# Runtime stage
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/build/libs /app/libs
RUN mv /app/libs/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
