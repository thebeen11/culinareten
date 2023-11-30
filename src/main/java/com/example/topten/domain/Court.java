package com.example.topten.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Court {

    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    private Category category;

    private Integer totalVote;

    private String googleMap;

    private String address;

    private String urbanVillage;

    private String district;

    private String city;

    private String province;
}
