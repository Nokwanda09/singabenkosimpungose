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

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    private String wasteCategory;
    
    @NotBlank
    @Size(min=10)
    private String recyclingTip;

}
