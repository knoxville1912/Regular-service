package com.example.regular.controller;

import com.example.regular.converter.LifeDataConverter;
import com.example.regular.dto.AttachmentDTO;
import com.example.regular.dto.LifeDataDTO;
import com.example.regular.dto.MedicalHistoryDTO;
import com.example.regular.dto.PatientDTO;
import com.example.regular.model.LifeData;
import com.example.regular.service.AnalysisService;
import com.example.regular.service.LifeDataService;
import com.example.regular.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/regular")
public class LifeDataController {

    @Autowired
    private LifeDataService lifeDataService;

    @Autowired
    private MailService mailService;

    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private LifeDataConverter lifeDataConverter;

    @GetMapping("/get-life-data")
    public List<LifeDataDTO> getLifeData() throws IOException {
        return lifeDataService.getLifeDataWithFile().stream()
                .map(lifeDataConverter::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/update-life-data-with-file")
    public void updateLifeDataWithFile() throws IOException {
        lifeDataService.updateLifeData(lifeDataService.getLifeDataWithFile());
    }

    @PostMapping("/update-life-data-with-rest")
    public void updateLifeDataWithRest() {
        lifeDataService.updateLifeData(lifeDataService.getLifeDataWithRest());
    }

    @PostMapping("/update-life-data-with-rest-by-scheduler")
    public void updateLifeDataWithRestByScheduler(@RequestBody List<LifeData> lifeDataList) {
        lifeDataService.updateLifeData(lifeDataList);
    }

    @GetMapping("/get-medical-history-by-patient-id/{id}")
    public List<MedicalHistoryDTO> getMedicalHistoryByPatientId(@PathVariable Long id) {
        return lifeDataService.getMedicalHistoryByPatientId(id);
    }

    @GetMapping("/get-all-patients-by-doctors-id/{id}")
    public List<PatientDTO> getAllPatientsByDoctorsId(@PathVariable Long id) {
        return lifeDataService.getAllPatientByDoctorsId(id);
    }

    @GetMapping("/get-all-patient-id-with-life-data")
    public List<Long> getAllPatientIdWithLifeData() {
        return lifeDataService.getAllPatientIdWithLifeData();
    }

    @PostMapping("/send-mail")
    public void sendMail(@RequestParam String to, String subject, String text) {
        mailService.sendSimpleMessage(to, subject, text);
    }

    @PostMapping("/send-mail-with-attachment")
    public void sendMailWithAttachment(@RequestParam String to,
                                       @RequestParam String subject,
                                       @RequestParam String text,
                                       @RequestBody AttachmentDTO attachmentDTO) throws MessagingException {
        mailService.sendMessageWithAttachment(to, subject, text, attachmentDTO.getPathToAttachment());
    }

    @PostMapping("/write-excel-analys-by-patient-id-dayli/{id}")
    public void writeFileAnalysisExcelByPatientId(@PathVariable Long id) throws IOException {
        analysisService.writeFileAnalysisExcelByPatientId(id);
    }
}
