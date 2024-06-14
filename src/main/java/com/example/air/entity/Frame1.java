package com.example.air.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Frame1 {
    @Id
    private String id;
    private int CO2;
    private int HCHO;
    private int TVOC;

    public Frame1(int CO2, int HCHO, int TVOC) {
        this.CO2 = CO2;
        this.HCHO = HCHO;
        this.TVOC = TVOC;
    }
}
