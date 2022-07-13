package com.example.regular.service;

import com.example.regular.dao.LifeDataDAO;
import com.example.regular.dto.MedicalHistoryDTO;
import com.example.regular.dto.MedicalHistoryListDTO;
import com.example.regular.dto.PatientDTO;
import com.example.regular.mapper.LifeDataFileReaderMapper;
import com.example.regular.model.LifeData;
import org.apache.poi.ss.formula.functions.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import program.FileWorker;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class LifeDataService {
    @Autowired
    private LifeDataDAO lifeDataDAO;

    public List<LifeData> getLifeDataWithFile() throws IOException {
        File file = new File("C:\\Users\\Danko\\IdeaProjects\\medical\\medical\\Regular\\lifedata\\LifeData.csv");
        return FileWorker.readFileCSV(file, new LifeDataFileReaderMapper());
    }

    public List<LifeData> getLifeDataWithRest() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8082/gateway/generate-life-data",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LifeData>>(){}
        ).getBody();
    }

    public void updateLifeData(List<LifeData> lifeDataList) {
        lifeDataDAO.updateLifeData(lifeDataList);
    }

    public List<MedicalHistoryDTO> getMedicalHistoryByPatientId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080/medicine/get-all-medical-history-patient/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MedicalHistoryDTO>>(){}
        ).getBody();
    }

    public List<PatientDTO> getAllPatientByDoctorsId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080/medicine/get-all-patients-by-doctors-id/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PatientDTO>>(){}
        ).getBody();
    }

    public List<Long> getAllPatientIdWithLifeData() {
        return lifeDataDAO.getAllPatientIdWithLifeData();
    }
}
