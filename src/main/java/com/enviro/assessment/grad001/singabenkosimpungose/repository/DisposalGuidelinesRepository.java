package com.enviro.assessment.grad001.singabenkosimpungose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.enviro.assessment.grad001.singabenkosimpungose.model.DisposalGuideline;

@Repository
public interface DisposalGuidelinesRepository extends JpaRepository<DisposalGuideline, Long>{

    public List<DisposalGuideline> findAllByWasteCategory(String wasteCategory);

}
