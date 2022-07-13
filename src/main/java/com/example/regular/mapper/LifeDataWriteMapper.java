package com.example.regular.mapper;

import com.example.regular.model.LifeData;
import program.WriteMapper;

public class LifeDataWriteMapper implements WriteMapper<LifeData> {
    @Override
    public String[] map(LifeData lifeData) {
        return new String[]{
                String.valueOf(lifeData.getId()),
                String.valueOf(lifeData.getDateTime()),
                String.valueOf(lifeData.getTemperature()),
                String.valueOf(lifeData.getDiastolicPressure()),
                String.valueOf(lifeData.getSystolicPressure()),
                String.valueOf(lifeData.getSaturation()),
                String.valueOf(lifeData.getPulse()),
                String.valueOf(lifeData.getPatientId())
        };
    }
}
