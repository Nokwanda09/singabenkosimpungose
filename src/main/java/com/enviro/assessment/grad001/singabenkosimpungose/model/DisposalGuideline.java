package com.enviro.assessment.grad001.singabenkosimpungose.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;;


/**
 * Represents a disposal guideline entity.
 * 
 * <p>This entity stores information about waste disposal guidelines,
 * including the waste category and specific disposal instructions.
 */
@Entity
@Table(name="DisposalGuidelines")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DisposalGuideline {

     /**
     * The unique identifier for a disposal guideline.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    /**
     * The category of waste this guideline applies to.
     * This field cannot be null.
     */
    @NotNull
    private String wasteCategory;

     /**
     * The detailed disposal guideline for the specified waste category.
     * This field must not be blank and must have a minimum length of 30 characters.
     */
    @NotBlank
    @Size(min=30)
    private String disposalGuideline;
}
