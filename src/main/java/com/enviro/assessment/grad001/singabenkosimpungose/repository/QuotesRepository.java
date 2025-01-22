package com.enviro.assessment.grad001.singabenkosimpungose.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.enviro.assessment.grad001.singabenkosimpungose.model.SustainabilityQuote;;

/**
 * Repository interface for managing {@link SustainabilityQuote} entities.
 * 
 * <p>Provides methods for performing CRUD operations on the SustainabilityQuote
 * table in the database.
 */
@Repository
public interface QuotesRepository extends JpaRepository<SustainabilityQuote, Long>{

}
