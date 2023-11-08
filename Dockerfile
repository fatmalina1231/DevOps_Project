FROM openjdk:11
EXPOSE 8082
ARG JAR_FILE=target/DevOps_Project-2.1.jar
ADD target/devops_project.jar devops_project.jar
ENTRYPOINT ["java","-jar","target/devops_project.jar"]
