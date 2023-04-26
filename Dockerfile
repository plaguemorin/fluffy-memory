FROM eclipse-temurin:20-jre
WORKDIR /app

VOLUME /tmp
VOLUME /data

ARG JAR_FILE
COPY ${JAR_FILE} app.jar

ENV ANTAGONIST_DATA_DIR=/data
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
