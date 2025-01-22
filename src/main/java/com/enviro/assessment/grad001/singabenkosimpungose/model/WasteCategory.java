package com.enviro.assessment.grad001.singabenkosimpungose.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name="WasteCategories")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WasteCategory {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max=50, message="Name cannot have more than 50 characters") 
    @Column(name="name", unique=true)
    private String name;

    @NotNull
    @Size(min=50)
    private String description;
}
