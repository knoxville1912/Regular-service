package com.example.regular.converter;

import com.example.regular.dto.LifeDataDTO;
import com.example.regular.model.LifeData;
import org.springframework.stereotype.Component;

@Component
public class LifeDataConverter {
    public LifeDataDTO toDTO(LifeData lifeData) {
        return new LifeDataDTO(lifeData.getId(),
                lifeData.getDateTime(),
                lifeData.getTemperature(),
                lifeData.getDiastolicPressure(),
                lifeData.getSystolicPressure(),
                lifeData.getSaturation(),
                lifeData.getPulse(),
                lifeData.getPatientId());
    }

    public LifeData toModel(LifeDataDTO lifeDataDTO) {
        return new LifeData(lifeDataDTO.getId(),
                lifeDataDTO.getDateTime(),
                lifeDataDTO.getTemperature(),
                lifeDataDTO.getDiastolicPressure(),
                lifeDataDTO.getSystolicPressure(),
                lifeDataDTO.getSaturation(),
                lifeDataDTO.getPulse(),
                lifeDataDTO.getPatientId());
    }
}
