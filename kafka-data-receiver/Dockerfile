FROM maven:3.8.6-eclipse-temurin-17-alpine as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build app/target/kafka-data-receiver-0.0.1.jar data-receiver
CMD java -jar data-receiver