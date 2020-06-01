FROM java:8

COPY ./target/hotel-0.0.1-SNAPSHOT.jar hotel-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","hotel-0.0.1-SNAPSHOT.jar"]
