package com.example.regular.dto;

import java.time.LocalDateTime;

public class LifeDataDTO {
    private Long id;
    private LocalDateTime dateTime;
    private Double temperature;
    private Integer diastolicPressure;
    private Integer systolicPressure;
    private Integer saturation;
    private Integer pulse;
    private Long patientId;

    public LifeDataDTO() {
    }

    public LifeDataDTO(Long id,
                       LocalDateTime dateTime,
                       Double temperature,
                       Integer diastolicPressure,
                       Integer systolicPressure,
                       Integer saturation,
                       Integer pulse,
                       Long patientId) {
        this.id = id;
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.diastolicPressure = diastolicPressure;
        this.systolicPressure = systolicPressure;
        this.saturation = saturation;
        this.pulse = pulse;
        this.patientId = patientId;
    }

    public LifeDataDTO(LocalDateTime dateTime,
                       Double temperature,
                       Integer diastolicPressure,
                       Integer systolicPressure,
                       Integer saturation,
                       Integer pulse,
                       Long patientId) {
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.diastolicPressure = diastolicPressure;
        this.systolicPressure = systolicPressure;
        this.saturation = saturation;
        this.pulse = pulse;
        this.patientId = patientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(Integer diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public Integer getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(Integer systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public Integer getSaturation() {
        return saturation;
    }

    public void setSaturation(Integer saturation) {
        this.saturation = saturation;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
