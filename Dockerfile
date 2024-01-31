FROM eclipse-temurin:21-jre
COPY target/lib/*.jar /app/lib/
COPY target/testandbuild-1.0-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-cp","/app/app.jar:/app/lib/*","org.example.App"]
