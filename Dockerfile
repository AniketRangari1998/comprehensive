FROM openjdk:11
ADD target/comprehensive_project-1.jar comprehensive_project-1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","comprehensive_project-1.jar"]