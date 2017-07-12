FROM openjdk:8-alpine

RUN mkdir -p /home/gradle/src
WORKDIR /home/gradle/src

COPY . /home/gradle/src
RUN gradle build
RUN tar -xvf build/distributions/source-stream.tar

ENV KAFKA_ADDRESS "localhost:9092"

WORKDIR /home/gradle/src/source-stream/lib/
CMD java $JAVA_OPTIONS -cp "*" sourcestream.Main
