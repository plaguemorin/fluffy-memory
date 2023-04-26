#!/bin/sh

./mvnw dependency:go-offline
./mvnw install

docker build --build-arg JAR_FILE=target/antagonistsp.jar -t screenshot/antagonistsp:latest .
