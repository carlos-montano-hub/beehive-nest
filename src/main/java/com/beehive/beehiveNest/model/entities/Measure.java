package com.beehive.beehiveNest.model.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Measure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime time;
    @ManyToOne
    @JoinColumn(name = "beehive_id", nullable = false)
    private Beehive beehive;
    private double temperature;
    private double humidity;
    private double weight;
    private String audioRecordingUrl;
}
