FROM amazoncorretto:17
ARG JAR_FILE=targer/*.jar
COPY ${JAR_FILE} app.jar
CMD apt-get update -y
ENTRYPOINT ["java", "-jar", "app.jar"]
