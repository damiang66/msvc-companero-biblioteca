FROM openjdk:19-alpine
VOLUME /tmp
EXPOSE 8761
#RUN ./mvnw clean package -DskipTests
ADD ./target/msvc-libro-0.0.1-SNAPSHOT.jar msvc-libro.jar
ENTRYPOINT ["java", "-jar", "/msvc-libro.jar"]