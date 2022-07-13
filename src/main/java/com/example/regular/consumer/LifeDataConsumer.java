package com.example.regular.consumer;

import com.example.regular.converter.LifeDataMessageConverter;
import com.example.regular.dto.LifeDataDTO;
import com.example.regular.dto.LifeDataMessageDTO;
import com.example.regular.model.LifeData;
import com.example.regular.service.LifeDataService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LifeDataConsumer {

    @Autowired
    private LifeDataService lifeDataService;

    @Autowired
    private LifeDataMessageConverter lifeDataMessageConverter;

    @JmsListener(destination = "LifeDataUsual")
    void listen(List<LifeData> lifeDataMessageDTOList) {
        ObjectMapper mapper = new ObjectMapper();
        List<LifeDataMessageDTO> lifeDataMessageDTOS = mapper.convertValue(
                lifeDataMessageDTOList,
                new TypeReference<List<LifeDataMessageDTO>>(){}
        );
        lifeDataService.updateLifeData(lifeDataMessageDTOS.stream().map(lifeDataMessageConverter::toModel).collect(Collectors.toList()));

//        System.out.println("-------------" + lifeDataMessageDTOList + "---------");
    }
}
