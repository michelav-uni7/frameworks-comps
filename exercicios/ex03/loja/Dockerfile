FROM openjdk:11-slim as build
WORKDIR /workspace/

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY compras-app compras-app
COPY compras-biz compras-biz
COPY vendas vendas
# COPY src src

RUN ./mvnw package -DskipTests

FROM michelav/wildfly:16-stretch

WORKDIR /opt/wildfly/standalone/deployments/

ARG DEPENDENCY=/workspace

COPY --from=build ${DEPENDENCY}/compras-app/target/compras-app-1.0.ear .
COPY --from=build ${DEPENDENCY}/vendas/target/vendas-1.0.war .