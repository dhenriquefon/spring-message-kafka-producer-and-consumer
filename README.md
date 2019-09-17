# spring-message-kafka-producer-and-consumer
exemplo simples de produzir e escrever mensagens no KAFKA (sem schema registry)

First, install and configure  apache kafka:

http://kafka.apache.org/quickstart
steps:
===========================
start do kafka
================
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties -> kafka startado em um noh setado nesse arquivo de configuracao
================
 
criando um topico
===============
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
===============
 
listando topico
===============
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
===============
 
enviando mensagem (producer)
===============
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
 
teste mensagem 1
teste mensagem 2
===============
 
consumindo mensagem (consumer)
===============
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
===============
 
configurar multiplos cluester
==============
criar novos arquivos de configuracao
 
cp config/server.properties config/server-1.properties
 
config/server-1.properties:
    broker.id=1
    listeners=PLAINTEXT://:9093
    log.dirs=/tmp/kafka-logs-1
==============
 
criando kafka connector standalone
==============
bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties
=============
===========================

COMMAND TO BUILD APPLICATION
======================================
./mvnw clean package
======================================

COMMAND TO RUN APPLICATION
======================================
java -jar target/kafka-avro-0.0.1-SNAPSHOT.jar
======================================
