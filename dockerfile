FROM eclipse-temurin:17-jdk 

WORKDIR /app

COPY /credit-service/credit-service/target/credit-service-0.0.1-SNAPSHOT.jar  /app/credit.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","credit.jar"]