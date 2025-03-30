FROM openjdk:21-jdk

WORKDIR /app

COPY target/*.jar app.jar
COPY src/main/resources/templates /app/resources/templates

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]