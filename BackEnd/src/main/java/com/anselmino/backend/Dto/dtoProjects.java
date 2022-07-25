
package com.anselmino.backend.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProjects {
    @NotBlank
    private String title;
    private String tech;
    private String description;
    private String url;
    
    //Constructores

    public dtoProjects(String title, String tech, String description, String url) {
        this.title = title;
        this.tech = tech;
        this.description = description;
        this.url = url;
    }
    
    //Getters and Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
