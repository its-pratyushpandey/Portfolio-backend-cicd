package com.portfolio.dto;

import java.util.List;

public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private List<TagDto> tags;
    private String image;
    private String sourceCodeLink;
    private String liveLink;
    
    public ProjectDto() {}
    
    // Getters and Setters
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
    
    public List<TagDto> getTags() {
        return tags;
    }
    
    public void setTags(List<TagDto> tags) {
        this.tags = tags;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getSourceCodeLink() {
        return sourceCodeLink;
    }
    
    public void setSourceCodeLink(String sourceCodeLink) {
        this.sourceCodeLink = sourceCodeLink;
    }
    
    public String getLiveLink() {
        return liveLink;
    }
    
    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }
    
    public static class TagDto {
        private String name;
        private String color;
        
        public TagDto() {}
        
        public TagDto(String name, String color) {
            this.name = name;
            this.color = color;
        }
        
        // Getters and Setters
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getColor() {
            return color;
        }
        
        public void setColor(String color) {
            this.color = color;
        }
    }
}