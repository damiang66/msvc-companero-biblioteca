FROM openjdk:19-alpine
VOLUME /tmp
EXPOSE 8761
#RUN ./mvnw clean package -DskipTests
ADD ./target/msvc-eureka-0.0.1-SNAPSHOT.jar msvc-eureka.jar
ENTRYPOINT ["java", "-jar", "/msvc-eureka.jar"]