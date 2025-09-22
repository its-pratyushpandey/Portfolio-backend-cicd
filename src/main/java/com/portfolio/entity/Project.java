package com.portfolio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;
    
    @NotBlank(message = "Description is required")
    @Column(nullable = false, length = 2000)
    private String description;
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProjectTag> tags;
    
    private String image;
    
    @Column(name = "source_code_link")
    private String sourceCodeLink;
    
    @Column(name = "live_link")
    private String liveLink;
    
    @Column(name = "display_order")
    private Integer displayOrder = 0;
    
    public Project() {}
    
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
    
    public List<ProjectTag> getTags() {
        return tags;
    }
    
    public void setTags(List<ProjectTag> tags) {
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
    
    public Integer getDisplayOrder() {
        return displayOrder;
    }
    
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}