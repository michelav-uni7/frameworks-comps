FROM openjdk:11-slim as build
WORKDIR /workspace/

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY app app
COPY biz biz
COPY web web

RUN ./mvnw package -DskipTests

FROM michelav/wildfly:16-stretch

WORKDIR /opt/wildfly/standalone/deployments/

ARG DEPENDENCY=/workspace

COPY --from=build ${DEPENDENCY}/app/target/app-1.0.ear .