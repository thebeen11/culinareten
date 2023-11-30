package com.example.topten.service;

import com.example.topten.domain.Province;
import com.example.topten.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    public List<Province> findAllProvince(){
        return provinceRepository.findAll();
    }

    public Province findProvinceById(String id){
        return provinceRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public Province saveProvince(Province province){
        province.setId(UUID.randomUUID().toString());
        return  provinceRepository.save(province);
    }

    public void deleteProvinceById(String id){
        provinceRepository.deleteById(id);
    }
}
