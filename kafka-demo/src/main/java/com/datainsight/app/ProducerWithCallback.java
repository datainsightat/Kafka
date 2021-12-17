package com.datainsight.app;

// import org.apache.kafka.clients.producer.KafkaProducer;
// import org.apache.kafka.clients.producer.ProducerConfig;
// import org.apache.kafka.clients.producer.ProducerRecord;
// import org.apache.kafka.clients.producer.RecordMetadata;
// import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

// import javax.security.auth.callback.Callback;

/**
 * Hello world!
 *
 */
public class ProducerWithCallback
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        final Logger logger = LoggerFactory.getLogger(ProducerWithCallback.class);

        String bootstrapServers = "0.0.0.0:9092";

        //Create Producer Properties
        //https://kafka.apache.org/documentation/
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        //Create Producer
        KafkaProducer<String,String> producer = new KafkaProducer<String,String>(properties);

        for (int i=0; i<10; i++) {

            //Create Producer Record
            ProducerRecord<String,String> record = new ProducerRecord<String,String>("first_topic","hello world " + Integer.toString(i));

            //Send Data - Asynchonous
            producer.send(record, new Callback() {
            //String a = new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    //execute every time a record is successfully sent
                    if (e == null) {
                        //the record was successfully sent
                        logger.info("\nReceived new metadata." + 
                                    "\nTopic: " + recordMetadata.topic() + 
                                    "\nPartition: " + recordMetadata.partition() + 
                                    "\nOffset: " + recordMetadata.offset() + 
                                    "\nTimestamp: " + recordMetadata.timestamp());
                    } else {
                        logger.error("\nError while producing: ", e);
                    }
                }
            });
        };

        producer.flush();
        producer.close();
    }
}
