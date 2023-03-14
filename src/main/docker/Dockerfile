FROM openjdk:17.0.2-jdk-slim as build

WORKDIR /home/spring

ADD application.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract


FROM openjdk:17.0.2-slim

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    NEW_RELIC_APP_NAME=spring-demo  \
    JAVA_OPTS=""

WORKDIR /home/spring

RUN groupadd --gid=1000 spring && \
    useradd --uid=1000 --gid=1000 --shell /usr/sbin/nologin spring

# Add NewRelic agent
ADD newrelic/newrelic.jar newrelic/newrelic.jar

COPY --from=build /home/spring/dependencies/ ./
COPY --from=build /home/spring/snapshot-dependencies/ ./
COPY --from=build /home/spring/spring-boot-loader/ ./
COPY --from=build /home/spring/application/ ./

USER spring

EXPOSE 8080

ENTRYPOINT java -javaagent:"${HOME}/newrelic/newrelic.jar" org.springframework.boot.loader.JarLauncher
