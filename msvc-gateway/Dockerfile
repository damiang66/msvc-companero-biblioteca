FROM openjdk:19-alpine
VOLUME /tmp
EXPOSE 8761
#RUN ./mvnw clean package -DskipTests
ADD ./target/msvc-gateway-0.0.1-SNAPSHOT.jar msvc-gateway.jar
ENTRYPOINT ["java", "-jar", "/msvc-gateway.jar"]