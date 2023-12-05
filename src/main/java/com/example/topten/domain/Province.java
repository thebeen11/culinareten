package com.example.topten.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tbl_province")
public class Province {

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String name;
}
