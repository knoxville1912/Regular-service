package com.example.regular.service;

import com.example.regular.dao.LifeDataDAO;
import com.example.regular.mapper.LifeDataWriteMapper;
import com.example.regular.model.LifeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.FileWorker;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class AnalysisService {

    @Autowired
    private LifeDataDAO lifeDataDAO;

    public void writeFileAnalysisExcelByPatientId(Long patientId) throws IOException {
        List<LifeData> lifeData = lifeDataDAO.getLifeDataDailyOfPatient(patientId);
        FileWorker.writeFileXlS(
                "C:\\Users\\Danko\\IdeaProjects\\medical\\medical\\Regular\\lifedata\\fileLifeData" + patientId + "_" + LocalDate.now() + "",
                lifeData,
                new LifeDataWriteMapper(),
                new String[]{"id", "dateTime", "temperature", "diastolicPressure", "systolicPressure", "saturation", "pulse", "patientId"},
                "fileLifeData" + LocalDate.now() + "_" + patientId + ""
                );
    }
}
