FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package

FROM eclipse-temurin:21 AS deploy

WORKDIR /app

ENV DATABASE_URL=jdbc:postgresql://ip:5432/database_name
ENV SERVER_PORT=8080

EXPOSE ${SERVER_PORT}

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
