package com.example.topten.repository;

import com.example.topten.domain.TopChartDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TopChartRepository extends JpaRepository<TopChartDomain, String>, JpaSpecificationExecutor<TopChartDomain> {

    List<TopChartDomain> findTop5ById(String id);

}
