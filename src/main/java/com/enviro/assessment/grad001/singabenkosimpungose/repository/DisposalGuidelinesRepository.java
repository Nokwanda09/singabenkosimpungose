package com.enviro.assessment.grad001.singabenkosimpungose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.enviro.assessment.grad001.singabenkosimpungose.model.DisposalGuideline;

/**
 * Repository interface for managing {@link DisposalGuideline} entities.
 * 
 * <p>Provides methods for performing CRUD operations and custom queries
 * on the DisposalGuideline table in the database.
 */
@Repository
public interface DisposalGuidelinesRepository extends JpaRepository<DisposalGuideline, Long>{

    /**
     * Finds all disposal guidelines associated with the given waste category.
     * 
     * @param wasteCategory the waste category for which guidelines are to be retrieved.
     * @return a list of disposal guidelines matching the specified waste category.
     */
    public List<DisposalGuideline> findAllByWasteCategory(String wasteCategory);

}
