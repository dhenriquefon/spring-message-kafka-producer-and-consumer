# spring-message-kafka-producer-and-consumer
exemplo simples de produzir e escrever mensagens no KAFKA (sem schema registry)

First, install confluent platform:
https://docs.confluent.io/current/quickstart/ce-quickstart.html?_ga=2.164882175.1581225892.1568655608-766627929.1567455964#ce-quickstart

======================================
confluent local stop
 
confluent local start
 
confluent local status
    The local commands are intended for a single-node development environment
    only, NOT for production usage. https://docs.confluent.io/current/cli/index.html
 
control-center is [UP]
ksql-server is [UP]
connect is [UP]
kafka-rest is [UP]
schema-registry is [UP]
kafka is [UP]
zookeeper is [UP]
======================================

COMMAND TO BUILD APPLICATION
======================================
./mvnw clean package
======================================

COMMAND TO RUN APPLICATION
======================================
java -jar target/kafka-avro-0.0.1-SNAPSHOT.jar
======================================
