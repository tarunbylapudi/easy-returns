FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 9002
ADD target/naming-server.jar naming-server.jar
ENTRYPOINT ["java","-jar","/naming-server.jar"]