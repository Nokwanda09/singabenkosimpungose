package com.enviro.assessment.grad001.singabenkosimpungose.model;

import lombok.*;

import jakarta.persistence.*;


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
    
    private String wasteCategory;

    private String disposalGuideline;
}
