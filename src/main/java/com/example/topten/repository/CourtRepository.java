package com.example.topten.repository;

import com.example.topten.domain.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CourtRepository extends JpaRepository<Court, String>, JpaSpecificationExecutor<Court> {

}
