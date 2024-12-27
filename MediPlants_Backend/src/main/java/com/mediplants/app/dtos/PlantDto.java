package com.mediplants.app.dtos;

public class PlantDto {
    private Long id;
    private String name;
    private String description;
    private String properties;
    private String uses;
    private String precautions;
    private String interactions;
    private String region;
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getInteractions() {
        return interactions;
    }

    public void setInteractions(String interactions) {
        this.interactions = interactions;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public PlantDto(Long id, String name, String description, String properties, String uses, String precautions, String interactions, String region, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.properties = properties;
        this.uses = uses;
        this.precautions = precautions;
        this.interactions = interactions;
        this.region = region;
        this.category = category;
    }

    public PlantDto() {
    }
}