# Kafka

# Setup Java Project

    $ mvn archetype:generate -DgroupId=com.datainsight.app -DartifactId=kafka-demo -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

Add [Maven Repository](https://mvnrepository.com/) tp pom.xml

    $ cd kafka-demo
    $ mvn package
    $ java -cp target/kafka-demo-1.0-SNAPSHOT.jar com.datainsight.app.App