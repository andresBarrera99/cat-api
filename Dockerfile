FROM openjdk:17-jdk-alpine
COPY target/cat-api-0.0.1-SNAPSHOT.jar cat-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cat-api-0.0.1-SNAPSHOT.jar"]