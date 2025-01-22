package com.enviro.assessment.grad001.singabenkosimpungose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.singabenkosimpungose.model.WasteCategory;

/**
 * Repository interface for managing {@link WasteCategory} entities.
 * 
 * <p>Provides methods for performing CRUD operations on the WasteCategory
 * table in the database.
 */
@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long>{

}
