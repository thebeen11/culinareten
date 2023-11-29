package com.example.topten.service;

import com.example.topten.domain.TopChartDomain;
import com.example.topten.domain.param.TopChartDomainParam;
import com.example.topten.repository.TopChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopChartService {

    @Autowired
    private TopChartRepository topChartRepository;

    public TopChartDomain createOne(TopChartDomain topChart){

        return topChartRepository.save(topChart);
    }

    public Specification<TopChartDomain> filterName(String name){
        return (root,query,criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("name"),"%"+name+"%");
        };
    }

    public Specification<TopChartDomain> filterType(String type){
        return (root,query,criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("type"),type);
        };
    }


    public List<TopChartDomain> findAllTopChart(TopChartDomainParam param){
        Specification<TopChartDomain> specification = null;
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
                return topChartRepository.findAll(specification);
            }
        }

        return topChartRepository.findAll();
    }

    public List<TopChartDomain> findAll(){
        return topChartRepository.findAll();
    }

}
