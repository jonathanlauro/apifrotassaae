FROM openjdk

WORKDIR /opt/spring_boot

ENV  APP_NAME=apifrotassaae.jar


COPY /target/${APP_NAME} /opt/spring_boot

SHELL ["/bin/sh", "c"]


EXPOSE 8081

CMD ["java", "-jar", "/app/apifrotassaae.jar"]