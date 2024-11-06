FROM openjdk:17-jdk-alpine
COPY target/vikhlia-1.0.1-SNAPSHOT.jar vikhlia-1.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/vikhlia-1.0.1-SNAPSHOT.jar"]