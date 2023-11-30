package com.example.topten.repository;

import com.example.topten.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province, String> {
}
