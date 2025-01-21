package com.enviro.assessment.grad001.singabenkosimpungose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.singabenkosimpungose.model.DisposalGuildeline;

@Repository
public interface DisposalGuidelinesRepository extends JpaRepository<DisposalGuildeline, Long>{

}
