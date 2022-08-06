FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 9000
ADD target/authorization-service.jar authorization-service.jar
ENTRYPOINT ["java","-jar","/authorization-service.jar"]