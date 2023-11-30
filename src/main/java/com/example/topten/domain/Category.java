package com.example.topten.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tbl_category")
public class Category {
    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String name;
}
