package com.example.air.service;

import com.example.air.entity.Frame1;
import com.example.air.entity.Frame2;
import com.example.air.repository.Frame1Repository;
import com.example.air.repository.Frame2Repository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class Frame2Service {
    @Autowired
    private final Frame2Repository frame2Repository;
    private List<Frame2> latestData;
    @Autowired
    private EmailService emailService;

    public void addFrametwo(int tempValue, int humValue) {
        Frame2 frame = new Frame2();
        frame.setTemp(tempValue);
        frame.setHumidity(humValue);
        frame.setDate(new Date());
        frame2Repository.save(frame);
    }

    public List<Frame2> getAllFrames() {
        return frame2Repository.findAll();
    }

    public Frame2 getFrame2(String id) {
        return frame2Repository.findById(id).orElse(null);
    }
    public Frame2 getLatestFrame1() {
        return frame2Repository.findTopByOrderByDateDesc();
    }
    public String deleteFrame2(String id) {
        Frame2 frame2 = frame2Repository.findById(id).orElse(null);
        if (frame2 == null) {
            return "this frame does not exsist!";
        } else {
            frame2Repository.delete(frame2);
            return "frame deleted successufully with id:  " + id;
        }
    }

    /////////////////////////////////// get data after scheduled period///////////
   /* @Scheduled(fixedRate = 10000) // Polling every 10 seconds (adjust as needed)
    public void pollDatabase() {
        List<Frame2> currentData = frame2Repository.findAll();

        if (latestData == null) {
            latestData = currentData;
            return;
        }

        List<Frame2> newData = currentData.stream()
                .filter(frame -> !latestData.contains(frame))
                .collect(Collectors.toList());

        if (!newData.isEmpty()) {
            System.out.println("New data: " + newData);
            checkCO2(newData);
        }

        latestData = currentData;
    }

    private void checkCO2(List<Frame1> data) {
        for (Frame1 frame : data) {
            if (frame.getCO2() > 1400) {
                EmailRequest emailRequest = new EmailRequest();
                emailRequest.setTo("mayssa.bensalah@etudiant-isi.utm.tn");
                emailRequest.setBody("The gas level has exceeded the threshold. Current level: " + frame.getCO2());
                emailService.sendEmail(emailRequest);
            }
        }
    }*/

}
