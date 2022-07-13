package com.example.regular.dto;

import java.util.ArrayList;
import java.util.List;

public class MedicalHistoryListDTO {
    private List<MedicalHistoryDTO> medicalHistoryDTOList;

    public MedicalHistoryListDTO() {
        medicalHistoryDTOList = new ArrayList<>();
    }

    public MedicalHistoryListDTO(List<MedicalHistoryDTO> medicalHistoryDTOList) {
        this.medicalHistoryDTOList = medicalHistoryDTOList;
    }

    public List<MedicalHistoryDTO> getMedicalHistoryDTOList() {
        return medicalHistoryDTOList;
    }

    public void setMedicalHistoryDTOList(List<MedicalHistoryDTO> medicalHistoryDTOList) {
        this.medicalHistoryDTOList = medicalHistoryDTOList;
    }
}
