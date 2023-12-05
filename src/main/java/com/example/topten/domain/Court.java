package com.example.topten.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Court {

    @Id
    String id;

    @Column(unique = true, nullable = false)
    String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Category category;

    Integer totalVote;

    String googleMap;

    String address;

    String urbanVillage;

    String district;

    String city;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Province province;
}
