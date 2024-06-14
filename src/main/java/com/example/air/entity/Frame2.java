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
public class Frame2 {
    @Id
    private String id;
    private int temp;
    private int humidity;

    public Frame2(int temp, int humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }
}
