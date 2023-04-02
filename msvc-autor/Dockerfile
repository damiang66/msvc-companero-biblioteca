FROM openjdk:19-alpine
VOLUME /tmp
EXPOSE 8761
#RUN ./mvnw clean package -DskipTests
ADD ./target/msvc-autor-0.0.1-SNAPSHOT.jar msvc-autor.jar
ENTRYPOINT ["java", "-jar", "/msvc-autor.jar"]