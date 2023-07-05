# kafka-zookeeper-springboot

Kafka setup reference link: https://kafka.apache.org/quickstart

Apache Kafka can be started using ZooKeeper or KRaft.

Commands to follow for kafka and zookeeper set up:

1.Download kafka from https://dlcdn.apache.org/kafka/3.5.0/kafka_2.13-3.5.0.tgz 
And store into D:\Learning\kafka then unzip it there only.

2.Set path in environment veriable as D:\Learning\kafka\kafka_2.13-3.5.0\bin\windows

3.Start the kafka – 
Open cmd in D:\Learning\kafka\kafka_2.13-3.5.0\bin\windows> and run 
zookeeper-server-start.bat ..\..\config\zookeeper.properties
Open another cmd  in D:\Learning\kafka\kafka_2.13-3.5.0\bin\windows> and run 
kafka-server-start.bat ..\..\config\server.properties

4.Create the topic to store your events -  
Open another cmd  in D:\Learning\kafka\kafka_2.13-3.5.0\bin\windows> and run 
kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092
kafka-topics.bat --describe --topic quickstart-events --bootstrap-server localhost:9092

5.Write some topics into the topic – 
Open another cmd  in D:\Learning\kafka\kafka_2.13-3.5.0\bin\windows> and run 
kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092
This is my first event
This is my second event

6.Read the events – 
Open another cmd  in D:\Learning\kafka\kafka_2.13-3.5.0\bin\windows> and run 
kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092


create spring boot project using https://start.spring.io/

GET -> http://localhost:8080/api/kafka/publish?message=hellow kafka

POST-> http://localhost:8080/api/kafka/publish/user
{
    "id": 101,
    "name": "vishal",
    "mobileNo":8989789098

}
