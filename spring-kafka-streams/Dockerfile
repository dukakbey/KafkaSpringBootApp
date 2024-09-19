FROM maven:3.8.6-eclipse-temurin-17-alpine as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests 

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
RUN apk update && apk add --no-cache libstdc++ 
COPY --from=build /app/target/spring-kafka-streams-0.0.1.jar stream
CMD ["java", "-jar", "stream"]
