package com.example.topten.controller;

import com.example.topten.domain.Province;
import com.example.topten.service.ProvinceService;
import jakarta.validation.Valid;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.util.ArrayList;
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

    @PostMapping("/batch")
    public ResponseEntity<List<Province>> saveProvinces() throws JSONException {
        String url = "https://api.binderbyte.com/wilayah/provinsi?api_key=f64f3d9fb16066c6b7e8348c7ca1381b017902d82efb2387ee467995f3230b54";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(response);
        JSONArray valueArray = jsonResponse.getJSONArray("value");

        List<Province> provinces = new ArrayList<Province>();


        // Access elements in the "value" array
        for (int i = 0; i < valueArray.length(); i++) {
            JSONObject item = valueArray.getJSONObject(i);
            String id = item.getString("id");
            String name = item.getString("name");
            Province province = new Province();

            province.setId(id);
            province.setName(name);

            provinces.add(province);
        }
        List<Province> provinceResponse = provinceService.saveBatchProvinces(provinces);


        return ResponseEntity.ok(provinceResponse);
    }

}
