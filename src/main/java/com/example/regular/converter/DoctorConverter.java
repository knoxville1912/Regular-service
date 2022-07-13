package com.example.regular.converter;

import com.example.regular.dto.DoctorDTO;
import com.example.regular.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorConverter {
    public DoctorDTO toDTO(Doctor doctor) {
        return new DoctorDTO(doctor.getId(),
                doctor.getName(),
                doctor.getBirthDate(),
                doctor.getSpeciality(),
                doctor.getMail(),
                doctor.getPhone(),
                doctor.getStartDate(),
                doctor.getEndDate());
    }

    public Doctor toModel(DoctorDTO doctorDTO) {
        return new Doctor(doctorDTO.getId(),
                doctorDTO.getName(),
                doctorDTO.getBirthDate(),
                doctorDTO.getSpeciality(),
                doctorDTO.getMail(),
                doctorDTO.getPhone(),
                doctorDTO.getStartDate(),
                doctorDTO.getEndDate());
    }
}
