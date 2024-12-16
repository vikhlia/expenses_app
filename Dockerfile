FROM openjdk:17-jdk-slim
COPY target/vikhlia-1.0.1-SNAPSHOT.jar vikhlia-1.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/vikhlia-1.0.1-SNAPSHOT.jar"]
