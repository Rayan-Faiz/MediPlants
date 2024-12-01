package com.mediplants.app.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    private String properties;
    private String uses;
    private String precautions;
    private String interactions;
    private String region;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}

