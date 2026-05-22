FROM gradle:jdk25

WORKDIR /app

COPY . .

RUN gradle clean build

CMD ["java", "-jar", "build/libs/search_service-0.0.1-SNAPSHOT.jar"]