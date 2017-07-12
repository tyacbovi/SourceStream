FROM gradle:jdk8-alpine

RUN mkdir -p /home/gradle/src
WORKDIR /home/gradle/src

RUN apk add sudo

COPY . /home/gradle/src
RUN sudo rm ./generated_entities/src/main/java/org/sourcestream/entities/*.java
RUN sudo gradle build
RUN tar -xvf build/distributions/source-stream.tar

ENV KAFKA_ADDRESS "localhost:9092"

WORKDIR /home/gradle/src/source-stream/lib/
CMD java $JAVA_OPTIONS -cp "*" sourcestream.Main
