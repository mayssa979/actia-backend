package com.example.air.service;

import com.example.air.entity.Frame1;
import com.example.air.entity.Frame2;
import com.example.air.repository.Frame1Repository;
import com.example.air.repository.Frame2Repository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class Frame2Service {
    @Autowired
    private final Frame2Repository frame2Repository;
    private List<Frame2> latestData;
    public void addFrametwo(int humidity, int temperature) {
        Frame2 frame = new Frame2();
        frame.setHumidity(humidity);
        frame.setTemp(temperature);
        frame2Repository.save(frame);
    }

}
