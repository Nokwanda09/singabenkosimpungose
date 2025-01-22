package com.enviro.assessment.grad001.singabenkosimpungose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.enviro.assessment.grad001.singabenkosimpungose.model.RecyclingTip;

/**
 * Repository interface for managing {@link RecyclingTip} entities.
 * 
 * <p>Provides methods for performing CRUD operations and custom queries
 * on the RecyclingTip table in the database.
 */
@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long>{

     /**
     * Finds all recycling tips associated with the given waste category.
     * 
     * @param wasteCategory the waste category for which tips are to be retrieved.
     * @return a list of recycling tips matching the specified waste category.
     */
    List<RecyclingTip> findAllByWasteCategory(String wasteCategory);
}
