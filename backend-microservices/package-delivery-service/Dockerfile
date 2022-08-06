FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 9004
ADD target/packaging-delivery-service.jar packaging-delivery-service.jar
ENTRYPOINT ["java","-jar","/packaging-delivery-service.jar"]