package com.example.topten.service;

import com.example.topten.domain.Court;
import com.example.topten.domain.param.TopChartDomainParam;
import com.example.topten.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourtService {

    @Autowired
    private CourtRepository courtRepository;

    public Court saveCourt(Court court){
        court.setId(UUID.randomUUID().toString());
        court.setTotalVote(0);
        return courtRepository.save(court);
    }

    public Specification<Court> filterName(String name){
        return (root,query,criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("name"),"%"+name+"%");
        };
    }

    public Specification<Court> filterType(String type){
        return (root,query,criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("type"),type);
        };
    }


    public List<Court> findAllTopChart(TopChartDomainParam param){
        Specification<Court> specification = null;
        if( param != null ) {
            if (param.getName() != null) {
                specification = filterName(param.getName());
            }

            if (specification != null && param.getType() != null) {
                specification = specification.and(filterType(param.getType()));
            }else{
                if( param.getType() != null ) {
                    specification = filterType(param.getType());
                }
            }

            if( specification != null ){
                return courtRepository.findAll(specification);
            }
        }

        return courtRepository.findAll();
    }

    public List<Court> findAll(){
        return courtRepository.findAll();
    }

}
