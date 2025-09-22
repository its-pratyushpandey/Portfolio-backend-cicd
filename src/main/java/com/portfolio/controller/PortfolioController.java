package com.portfolio.controller;

import com.portfolio.entity.*;
import com.portfolio.dto.ContactMessageDto;
import com.portfolio.dto.ProjectDto;
import com.portfolio.service.PortfolioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000", "http://127.0.0.1:5173"})
public class PortfolioController {
    
    @Autowired
    private PortfolioService portfolioService;
    
    @GetMapping("/services")
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = portfolioService.getAllServices();
        return ResponseEntity.ok(services);
    }
    
    @GetMapping("/technologies")
    public ResponseEntity<List<Technology>> getAllTechnologies() {
        List<Technology> technologies = portfolioService.getAllTechnologies();
        return ResponseEntity.ok(technologies);
    }
    
    @GetMapping("/experiences")
    public ResponseEntity<List<Experience>> getAllExperiences() {
        List<Experience> experiences = portfolioService.getAllExperiences();
        return ResponseEntity.ok(experiences);
    }
    
    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        List<ProjectDto> projects = portfolioService.getAllProjects();
        return ResponseEntity.ok(projects);
    }
    
    @GetMapping("/certificates")
    public ResponseEntity<List<Certificate>> getAllCertificates() {
        List<Certificate> certificates = portfolioService.getAllCertificates();
        return ResponseEntity.ok(certificates);
    }
    
    @PostMapping("/contact")
    public ResponseEntity<Map<String, String>> submitContactForm(@Valid @RequestBody ContactMessageDto contactDto) {
        try {
            portfolioService.saveContactMessage(contactDto);
            
            Map<String, String> response = new HashMap<>();
            response.put("message", "Thank you for your message! I will get back to you soon.");
            response.put("status", "success");
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Sorry, there was an error sending your message. Please try again.");
            response.put("status", "error");
            
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/contact/messages")
    public ResponseEntity<List<ContactMessage>> getAllContactMessages() {
        List<ContactMessage> messages = portfolioService.getAllContactMessages();
        return ResponseEntity.ok(messages);
    }
    
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "Portfolio Backend API is running");
        return ResponseEntity.ok(response);
    }
}