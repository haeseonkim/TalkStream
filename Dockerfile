#Dockerfile
FROM openjdk:17.0.2-slim
ADD build/libs/talkstream.jar talkstream.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","talkstream.jar"]