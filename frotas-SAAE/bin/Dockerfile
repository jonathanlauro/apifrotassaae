FROM openjdk

RUN mkdir -p /app

ENV  APP_NAME=apifrotassaae.jar


COPY /target/${APP_NAME} /app

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/apifrotassaae.jar"]