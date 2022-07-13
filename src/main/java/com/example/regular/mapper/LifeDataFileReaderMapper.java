package com.example.regular.mapper;

import com.example.regular.model.LifeData;
import program.ReadMapper;

import java.time.LocalDateTime;

public class LifeDataFileReaderMapper implements ReadMapper<LifeData> {
    @Override
    public LifeData map(String[] params) {
        return new LifeData(
                LocalDateTime.parse(params[0]),
                Double.parseDouble(params[1]),
                Integer.parseInt(params[2]),
                Integer.parseInt(params[3]),
                Integer.parseInt(params[4]),
                Integer.parseInt(params[5]),
                Long.parseLong(params[6])
        );
    }
}
