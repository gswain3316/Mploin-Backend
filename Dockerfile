# Base image as jdk version 11
FROM openjdk:11
# Refer to Maven build 
ARG JAR_FILE=target/*.jar
# cp target/mploin.jar /opt/app/app.jar
COPY ${JAR_FILE} Mploin.jar
EXPOSE 9090
# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","Mploin.jar"]