package com.example.air.controller;

import com.example.air.entity.Frame1;
import com.example.air.service.Frame1Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frame1")
@AllArgsConstructor
@CrossOrigin("http://localhost:5173")
public class Frame1Controller {
    @Autowired
    private final Frame1Service frame1service;
   /* @PostMapping("/add")
    public String addFrameOne(@RequestBody Frame1 frame){
        frame1service.addFrameOne(frame);
        System.out.println("frame one "+ frame);
        return "frame saved successufully! "+frame ;
    }*/

    @GetMapping
    public List<Frame1> fetchAllFrameone(){
        return frame1service.getAllFrameone();
    }

    @GetMapping("/getOne/{id}")
    public Frame1 getFrame1(@PathVariable String id){
        return frame1service.getFrame1(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFrame1(@PathVariable String id){
        return frame1service.deleteFrame1(id);
    }
}
