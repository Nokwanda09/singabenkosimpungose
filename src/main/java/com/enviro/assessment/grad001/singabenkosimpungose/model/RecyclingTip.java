package com.enviro.assessment.grad001.singabenkosimpungose.model;

import lombok.*;

import jakarta.persistence.*;

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

    private String disposalTip;

}
