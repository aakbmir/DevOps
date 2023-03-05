#FROM java:11-jre
#WORKDIR usr/src
#ADD ./target/bookrecommendationservice-1.0.jar /usr/src/bookrecommendationservice-1.0.jar
#ENTRYPOINT ["java","-jar","bookrecommendationservice-1.0.jar"]


#FROM gradle:4.7.0-jdk8-alpine AS build
#COPY --chown=gradle:gradle . /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle build --no-daemon 

#FROM openjdk:8-jre-slim
#EXPOSE 8080
#RUN mkdir /app
#COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
#ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", #"-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]


FROM adoptopenjdk/openjdk11:latest
EXPOSE 8083
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} jenkinsapp.jar
ENTRYPOINT ["java", "-jar","/jenkinsapp.jar"]