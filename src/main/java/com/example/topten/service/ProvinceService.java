package com.example.topten.service;

import com.example.topten.domain.Province;
import com.example.topten.model.response.BinderbyteResponse;
import com.example.topten.repository.ProvinceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<Province> saveBatchProvinces(List<Province> provinces) {
        return provinceRepository.saveAll(provinces);
    }

    public void deleteProvinceById(String id){
        provinceRepository.deleteById(id);
    }
}
