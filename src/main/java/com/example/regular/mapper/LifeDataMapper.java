package com.example.regular.mapper;

import com.example.regular.model.LifeData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LifeDataMapper implements RowMapper<LifeData> {
    @Override
    public LifeData mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LifeData(
                rs.getLong("id"),
                rs.getTimestamp("date_time").toLocalDateTime(),
                rs.getDouble("temperature"),
                rs.getInt("diastolic_pressure"),
                rs.getInt("systolic_pressure"),
                rs.getInt("saturation"),
                rs.getInt("pulse"),
                rs.getLong("patient_id")
        );
    }
}
