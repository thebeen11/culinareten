package com.example.topten.controller;

import com.example.topten.domain.TopChartDomain;
import com.example.topten.domain.param.TopChartDomainParam;
import com.example.topten.service.TopChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topchart")
public class TopChartController {

    @Autowired
    private TopChartService topChartService;

    @GetMapping
    public ResponseEntity<List<TopChartDomain>> findAllTopChart(String name){

        TopChartDomainParam param = new TopChartDomainParam();
        param.setName(name);


        List<TopChartDomain> topChart = topChartService.findAllTopChart(param);

        return ResponseEntity.ok(topChart);
    }

    @GetMapping("/cek")
    public ResponseEntity<List<TopChartDomain>> findAll(){

        List<TopChartDomain> topChart = topChartService.findAll();

        return ResponseEntity.ok(topChart);
    }

    @PostMapping
    public  ResponseEntity<TopChartDomain> createTopChart(@RequestBody TopChartDomain topChartDomain){

       return ResponseEntity.ok(topChartService.createOne(topChartDomain));
    }
}
