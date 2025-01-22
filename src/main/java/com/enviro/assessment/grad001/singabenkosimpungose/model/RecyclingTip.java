package com.enviro.assessment.grad001.singabenkosimpungose.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="RecyclingTips")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RecyclingTip {

     /**
     * The unique identifier for a recycling tip.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    /**
     * The category of waste this tip applies to.
     * This field cannot be null.
     */
    @NotNull
    private String wasteCategory;
    
     /**
     * The detailed recycling tip for the specified waste category.
     * This field must not be blank and must have a minimum length of 10 characters.
     */
    @NotBlank
    @Size(min=10)
    private String recyclingTip;

}
