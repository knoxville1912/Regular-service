package com.example.regular.scheduler;

import com.example.regular.dao.LifeDataDAO;
import com.example.regular.dto.DoctorDTO;
import com.example.regular.service.AnalysisService;
import com.example.regular.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmailScheduler {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LifeDataDAO lifeDataDAO;

    @Autowired
    private MailService mailService;

    @Autowired
    private AnalysisService analysisService;

//    @Scheduled(fixedRate = 100000)
    @Scheduled(cron = "0 0 8 * * *")
    public void sentExcelFile() throws IOException, MessagingException {
        List<Long> listPatientId = lifeDataDAO.getAllPatientIdWithLifeData();
        Map<DoctorDTO, List<Long>> doctorDTOPatientMap = new HashMap<>();
        for (Long patientId : listPatientId) {
            DoctorDTO doctorDTO = restTemplate.getForObject(
                    "http://localhost:8080/medicine/get-active-doctor-by-patient/" + patientId,
                    DoctorDTO.class
            );
            List<Long> patientIdies = doctorDTOPatientMap.get(doctorDTO);
            if (patientIdies == null) {
                patientIdies = new ArrayList<>();
            }
            patientIdies.add(patientId);
            doctorDTOPatientMap.put(doctorDTO, patientIdies);
        }

        for (Long patientId : listPatientId) {
            analysisService.writeFileAnalysisExcelByPatientId(patientId);
        }

        for (Map.Entry<DoctorDTO, List<Long>> entry : doctorDTOPatientMap.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                mailService.sendMessageWithAttachment(
                        entry.getKey().getMail(),
                        "Analysis " + LocalDate.now() + " of patient with id " + entry.getValue().get(i),
                        "Daily Analysis",
                        "C:\\Users\\Danko\\IdeaProjects\\medical\\medical\\Regular\\lifedata\\fileLifeData" + entry.getValue().get(i) + "_" + LocalDate.now() + ".xls"
                );
            }
        }
    }
}
