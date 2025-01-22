package com.enviro.assessment.grad001.singabenkosimpungose.model;

import lombok.*;

import jakarta.persistence.*;


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

    private String author;

    private String quote;
}
