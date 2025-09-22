package com.portfolio.service;

import com.portfolio.entity.*;
import com.portfolio.repository.*;
import com.portfolio.dto.ContactMessageDto;
import com.portfolio.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PortfolioService {
    
    @Autowired
    private ServiceRepository serviceRepository;
    
    @Autowired
    private TechnologyRepository technologyRepository;
    
    @Autowired
    private ExperienceRepository experienceRepository;
    
    @Autowired
    private TestimonialRepository testimonialRepository;
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private CertificateRepository certificateRepository;
    
    @Autowired
    private ContactMessageRepository contactMessageRepository;
    
    // Service operations
    public List<com.portfolio.entity.Service> getAllServices() {
        return serviceRepository.findAllByOrderByDisplayOrderAsc();
    }
    
    // Technology operations
    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAllByOrderByDisplayOrderAsc();
    }
    
    // Experience operations
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAllByOrderByDisplayOrderAsc();
    }
    
    // Testimonial operations
    public List<Testimonial> getAllTestimonials() {
        return testimonialRepository.findAllByOrderByDisplayOrderAsc();
    }
    
    // Project operations
    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepository.findAllWithTags();
        return projects.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    
    private ProjectDto convertToDto(Project project) {
        ProjectDto dto = new ProjectDto();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setImage(project.getImage());
        dto.setSourceCodeLink(project.getSourceCodeLink());
        dto.setLiveLink(project.getLiveLink());
        
        if (project.getTags() != null) {
            dto.setTags(project.getTags().stream()
                .map(tag -> new ProjectDto.TagDto(tag.getName(), tag.getColor()))
                .collect(Collectors.toList()));
        }
        
        return dto;
    }
    
    // Certificate operations
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAllByOrderByDisplayOrderAsc();
    }
    
    // Contact operations
    public ContactMessage saveContactMessage(ContactMessageDto dto) {
        ContactMessage message = new ContactMessage();
        message.setName(dto.getName());
        message.setEmail(dto.getEmail());
        message.setMessage(dto.getMessage());
        return contactMessageRepository.save(message);
    }
    
    public List<ContactMessage> getAllContactMessages() {
        return contactMessageRepository.findAllByOrderByCreatedAtDesc();
    }
}