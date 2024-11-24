FROM gradle:jdk AS build
COPY --chown=gradle:gradle . /workdir/
WORKDIR /workdir/
RUN gradle clean build --no-daemon

FROM openjdk:21-oracle
RUN mkdir /app
ARG JAR_FILE=/workdir/build/libs/persistence-1.0.jar
COPY --from=build $JAR_FILE /app/persistence-1.0.jar
ENTRYPOINT ["java", "-jar", "/app/persistence-1.0.jar", "-Dspring.profiles.active=docker"]
