# Kafka

# Setup Java Project

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