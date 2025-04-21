FROM openjdk:21
COPY ./target/ems.jar ems.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","ems.jar"]
