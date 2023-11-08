FROM openjdk:11
EXPOSE 8082
ARG JAR_FILE=target/DevOps_Project-2.1.jar
ADD target/devops_project-1.0.jar devops_project-1.0.jar
ENTRYPOINT ["java","-jar","target/devops_project-1.0.jar"]
