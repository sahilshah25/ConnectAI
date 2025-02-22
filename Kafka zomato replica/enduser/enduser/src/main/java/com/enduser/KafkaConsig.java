package com.enduser;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsig {
    
    @KafkaListener(topics =AppConstants.LOCATION_UPDATE_TOPIC,groupId=AppConstants.GROUP_ID)
    public void updatedlocation(String value){

        System.out.println(value);

    }

}
