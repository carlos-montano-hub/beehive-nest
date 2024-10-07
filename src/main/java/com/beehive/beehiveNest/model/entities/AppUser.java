package com.beehive.beehiveNest.model.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class AppUser {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long phoneNumber;
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole role;
}

