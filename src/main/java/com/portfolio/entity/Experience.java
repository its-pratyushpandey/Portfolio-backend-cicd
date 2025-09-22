package com.portfolio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "experiences")
public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Title is required")
    @Column(nullable = false)
    private String title;
    
    private String company;
    
    @NotBlank(message = "Date is required")
    @Column(nullable = false)
    private String date;
    
    private String location;
    
    private String logo;
    
    @ElementCollection
    @CollectionTable(name = "experience_technologies", joinColumns = @JoinColumn(name = "experience_id"))
    @Column(name = "technology")
    private List<String> technologies;
    
    @ElementCollection
    @CollectionTable(name = "experience_points", joinColumns = @JoinColumn(name = "experience_id"))
    @Column(name = "point", length = 1000)
    private List<String> points;
    
    @Column(name = "display_order")
    private Integer displayOrder = 0;
    
    public Experience() {}
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getCompany() {
        return company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getLogo() {
        return logo;
    }
    
    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    public List<String> getTechnologies() {
        return technologies;
    }
    
    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }
    
    public List<String> getPoints() {
        return points;
    }
    
    public void setPoints(List<String> points) {
        this.points = points;
    }
    
    public Integer getDisplayOrder() {
        return displayOrder;
    }
    
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}