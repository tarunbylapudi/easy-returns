FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 9003
ADD target/component-processing-service.jar component-processing-service.jar
ENTRYPOINT ["java","-jar","/component-processing-service.jar"]