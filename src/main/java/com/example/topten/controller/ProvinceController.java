package com.example.topten.controller;

import com.example.topten.domain.Province;
import com.example.topten.service.ProvinceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/province")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping
    public ResponseEntity<List<Province>> findAllProvince(){
        List<Province> province = provinceService.findAllProvince();

        return ResponseEntity.ok(province);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Province> findProvinceById(@PathVariable String id){
        Province province = provinceService.findProvinceById(id);

        return ResponseEntity.ok(province);
    }

    @PostMapping
    public ResponseEntity<Province> saveProvince(@Valid @RequestBody Province provincePayload){
        Province province = provinceService.saveProvince(provincePayload);

        return ResponseEntity.ok(province);
    }
}
