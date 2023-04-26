FROM gradle:7.3.3-jdk11 as gradlebuilder-clean
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN ./gradlew bootJar -DskipTests


FROM azul/zulu-openjdk-alpine:11.0.13-jre
RUN mkdir /app
COPY --from=build /project/target/fooddeliveryapp-0.0.1-SNAPSHOT.jar /app/foogdeliveryapp-0.0.1-SNAPSHOT.jar
WORKDIR /app
CMD "java" "-jar" "fooddeliveryapp-0.0.1-SNAPSHOT.jar"
