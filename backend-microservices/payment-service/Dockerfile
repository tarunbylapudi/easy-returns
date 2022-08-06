FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 9005
ADD target/payment-service.jar payment-service.jar
ENTRYPOINT ["java","-jar","/payment-service.jar"]