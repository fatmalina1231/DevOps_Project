FROM openjdk:11
EXPOSE 8082
ARG JAR_FILE=target/DevOps_Project-2.1.jar
ADD target/DevOps_Project-2.1.jar DevOps_Project-2.1.jar
ENTRYPOINT ["java","-jar","/DevOps_Project-2.1.jar"]
