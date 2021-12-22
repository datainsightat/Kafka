# Kafka

# Create own Modules

## Setup Java Project

    $ mvn archetype:generate -DgroupId=com.datainsight.app -DartifactId=kafka-demo -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

Add [Maven Repository](https://mvnrepository.com/) tp pom.xml
* https://mvnrepository.com/artifact/org.codehaus.mojo/exec-maven-plugin
* https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
* https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients
<a/>

Upfate pm.xml (Plugins exec-maven-plugin)

    $ cd kafka-demo
    $ mvn package
    $ mvn exec:java

## Create Maven submodule

    $ mvn archetype:generate -DgroupId=com.datainsight.kafka-demo  -DartifactId=twitter

# Kafka Connectors

https://www.confluent.io/product/connectors/

## HDFS Sink Connector

[Documentation](https://docs.confluent.io/kafka-connect-hdfs/current/overview.html)

Donwload [hdfs connector](https://www.confluent.io/hub/confluentinc/kafka-connect-hdfs) and extract it to /opt/connectors/

Adapt etc/quickstart-hdfs.properties

    name=hdfs-sink
    connector.class=io.confluent.connect.hdfs.HdfsSinkConnector
    tasks.max=1
    topics=twitter_tweets
    #hdfs.url=hdfs://localhost:9000
    hdfs.url=hdfs://hive:54310
    flush.size=3

Run connector

    $ $KAFKA_HOME/bin/connect-standalone.sh $KAFKA_HOME/config/connect-standalone.properties /opt/connectors/confluentinc-kafka-connect-hdfs-10.1.3/etc/quickstart-hdfs.properties

## Check Kafka Cluster

    $ zookeeper-shell.sh 0.0.0.0:2181 ls /brokers/ids