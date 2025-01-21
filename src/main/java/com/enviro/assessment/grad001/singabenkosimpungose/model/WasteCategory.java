package com.enviro.assessment.grad001.singabenkosimpungose.model;

import lombok.*;
import jakarta.persistence.*;

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

    private String name;

    private String description;
}
