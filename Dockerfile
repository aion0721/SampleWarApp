FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean package


FROM quay.io/wildfly/wildfly
COPY --from=build /app/target/*.war /opt/jboss/wildfly/standalone/deployments/
