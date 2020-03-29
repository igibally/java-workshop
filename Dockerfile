FROM openjdk:8-jre-alpine
Add ./docker-spring-boot.jar  docker-spring-boot.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]