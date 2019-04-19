FROM openjdk:11-slim as build
WORKDIR /workspace/

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
# RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.war)

FROM michelav/wildfly:16-stretch

WORKDIR /opt/wildfly/standalone/deployments/app-web/

ARG DEPENDENCY=/workspace

COPY --from=build ${DEPENDENCY}/target/app-web-1.0.war .