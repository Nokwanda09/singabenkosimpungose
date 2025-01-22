package com.enviro.assessment.grad001.singabenkosimpungose.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;;


@Entity
@Table(name="DisposalGuidelines")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String wasteCategory;

    @NotBlank
    @Size(min=30)
    private String disposalGuideline;
}
