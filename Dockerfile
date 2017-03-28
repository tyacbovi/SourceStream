FROM openjdk:8-alpine

WORKDIR /usr/local/

ADD https://github.com/tyacbovi/SourceStream/releases/download/0.1/source-stream.tar .
RUN tar -xvf source-stream.tar

ENV KAFKA_ADDRESS "localhost:9092"

WORKDIR /usr/local/source-stream/lib/
CMD java -cp "*" sourcestream.Main
