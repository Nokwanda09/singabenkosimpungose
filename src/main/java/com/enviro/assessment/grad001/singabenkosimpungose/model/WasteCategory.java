package com.enviro.assessment.grad001.singabenkosimpungose.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Represents a waste category entity.
 * 
 * <p>This entity stores information about different categories of waste,
 * including their name and a detailed description.
 */
@Entity
@Table(name="WasteCategories")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WasteCategory {

     /**
     * The unique identifier for a waste category.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    /**
     * The name of the waste category.
     * This field must not be blank, cannot exceed 50 characters, and must be unique.
     */
    @NotBlank
    @Size(max=50, message="Name cannot have more than 50 characters") 
    @Column(name="name", unique=true)
    private String name;

    /**
     * A detailed description of the waste category.
     * This field must not be null and must have a minimum length of 50 characters.
     */
    @NotNull
    @Size(min=50)
    private String description;
}
