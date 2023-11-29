package com.example.topten.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TopChartDomain {

    @Id
    public String id;

    public String name;

    public String type;

    public Integer totalVote;
}
