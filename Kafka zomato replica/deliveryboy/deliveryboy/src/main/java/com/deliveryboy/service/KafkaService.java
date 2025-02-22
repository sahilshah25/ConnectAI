package com.deliveryboy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryboy.AppConstants;
@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
public boolean updateLocation(String location){

    
        kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);
        System.out.println("location produced");

    

  
    return true;


}

}
