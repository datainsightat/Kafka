package com.datainsight.app;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Hello world!
 *
 */
public class Producer 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        String bootstrapServers = "0.0.0.0:9092";

        //Create Producer Properties
        //https://kafka.apache.org/documentation/
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        //Create Producer
        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(properties);

        //Create Producer Record
        ProducerRecord<String,String> record = new ProducerRecord<String,String>("first_topic","hello world");

        //Send Data - Asynchonous
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
