FROM openjdk:8
ADD target/springboot-docker-example.jar springboot-docker-example.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "springboot-docker-example.jar"]