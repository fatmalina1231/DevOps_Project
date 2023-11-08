FROM openjdk:11
EXPOSE 8082
ARG JAR_FILE=target/DevOps_Project-2.1.jar
ADD target/DevOps_Project.jar DevOps_Project.jar
ENTRYPOINT ["java","-jar","target/DevOps_Project.jar"]
