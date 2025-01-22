package com.enviro.assessment.grad001.singabenkosimpungose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.enviro.assessment.grad001.singabenkosimpungose.model.RecyclingTip;

@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long>{

    List<RecyclingTip> findAllByWasteCategory(String wasteCategory);
}
