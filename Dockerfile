FROM openjdk:11
EXPOSE 8082
ADD target/KaddemProject-1.0.jar KaddemProject-1.0.jar
ENTRYPOINT ["java","-jar","/KaddemProject-1.0.jar"]
