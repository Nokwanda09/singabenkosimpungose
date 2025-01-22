package com.enviro.assessment.grad001.singabenkosimpungose.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name="Quotes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SustainabilityQuote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String author;

    @NotBlank
    @Size(min=50, max=50)
    private String quote;
}
