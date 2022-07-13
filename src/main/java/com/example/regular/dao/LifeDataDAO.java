package com.example.regular.dao;

import com.example.regular.mapper.LifeDataMapper;
import com.example.regular.model.LifeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LifeDataDAO {

    @Autowired
    private NamedParameterJdbcTemplate template;

    public void updateLifeData(List<LifeData> lifeDataList) {
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(lifeDataList.toArray());
        template.batchUpdate("INSERT INTO life_data (date_time, temperature, " +
                        "diastolic_pressure, systolic_pressure, " +
                        "saturation, pulse, patient_id) " +
                        "VALUES (:dateTime, :temperature, :diastolicPressure, " +
                        ":systolicPressure, :saturation, :pulse, :patientId)",
                batch);



        System.out.println();
    }

    public List<LifeData> getLifeDataDailyOfPatient(Long patientId) {
        return template.query(
                "SELECT * FROM life_data\n" +
                        "WHERE patient_id = :id AND date_time > (now() - interval '1 day');",
                new MapSqlParameterSource()
                        .addValue("id", patientId),
                new LifeDataMapper()
        );
    }

    public List<Long> getAllPatientIdWithLifeData() {
        return template.queryForList(
                "SELECT patient_id FROM life_data\n" +
                        "GROUP BY patient_id;",
                new MapSqlParameterSource(),
                Long.class
        );
    }

}
