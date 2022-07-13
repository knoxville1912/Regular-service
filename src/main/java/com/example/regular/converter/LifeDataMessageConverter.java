package com.example.regular.converter;

import com.example.regular.dto.LifeDataMessageDTO;
import com.example.regular.model.LifeData;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LifeDataMessageConverter {
    public LifeDataMessageDTO toDTO(LifeData lifeData) {
        return new LifeDataMessageDTO(lifeData.getId(),
                lifeData.getDateTime().toString(),
                lifeData.getTemperature(),
                lifeData.getDiastolicPressure(),
                lifeData.getSystolicPressure(),
                lifeData.getSaturation(),
                lifeData.getPulse(),
                lifeData.getPatientId());
    }

    public LifeData toModel(LifeDataMessageDTO lifeDataMessageDTO) {
        return new LifeData(lifeDataMessageDTO.getId(),
                LocalDateTime.parse(lifeDataMessageDTO.getDateTime().replace('T',' '), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                lifeDataMessageDTO.getTemperature(),
                lifeDataMessageDTO.getDiastolicPressure(),
                lifeDataMessageDTO.getSystolicPressure(),
                lifeDataMessageDTO.getSaturation(),
                lifeDataMessageDTO.getPulse(),
                lifeDataMessageDTO.getPatientId());
    }
}
