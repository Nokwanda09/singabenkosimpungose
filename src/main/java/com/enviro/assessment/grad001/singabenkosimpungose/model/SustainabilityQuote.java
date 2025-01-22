package com.enviro.assessment.grad001.singabenkosimpungose.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Represents a sustainability quote entity.
 * 
 * <p>This entity stores inspirational quotes related to sustainability,
 * including the author's name and the quote text.
 */

@Entity
@Table(name="Quotes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SustainabilityQuote {

      /**
     * The unique identifier for a sustainability quote.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The author of the sustainability quote.
     * This field must not be null.
     */
    @NotNull
    private String author;

    /**
     * The sustainability quote text.
     * This field must not be blank and must have exactly 50 characters.
     */
    @NotBlank
    @Size(min=50, max=50)
    private String quote;
}
