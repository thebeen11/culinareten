package com.example.topten.controller;

import com.example.topten.domain.Court;
import com.example.topten.domain.param.TopChartDomainParam;
import com.example.topten.repository.CourtRepository;
import com.example.topten.service.CourtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/court")
public class CourtController {

    @Autowired
    private CourtService courtService;

    @GetMapping
    public ResponseEntity<List<Court>> findAllTopChart(String name){

        TopChartDomainParam param = new TopChartDomainParam();
        param.setName(name);


        List<Court> court = courtService.findAllTopChart(param);

        return ResponseEntity.ok(court);
    }

    @PostMapping
    public  ResponseEntity<Court> createTopChart(@Valid @RequestBody Court courtPayload, Errors errors){

        Court court = courtService.saveCourt(courtPayload);

       return ResponseEntity.ok(court);
    }

    @DeleteMapping("/{id}")
    public void deleteCourt(@PathVariable  String id){
        courtService.deleteCourt(id);
    }
}
