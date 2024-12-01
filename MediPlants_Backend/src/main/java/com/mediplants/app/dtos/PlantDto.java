package com.mediplants.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantDto {
    private Long id;
    private String name;
    private String description;
    private String properties;
    private String uses;
    private String precautions;
    private String interactions;
    private String region;
    private Long categoryId;
}