package com.portfolio.service;

import com.portfolio.entity.*;
import com.portfolio.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class DataInitializationService {
    
    @Value("${portfolio.data.initialization.enabled:true}")
    private boolean initializationEnabled;
    
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
    
    @PostConstruct
    public void initializeData() {
        if (!initializationEnabled) {
            return;
        }
        
        if (serviceRepository.count() == 0) {
            initializeServices();
        }
        if (technologyRepository.count() == 0) {
            initializeTechnologies();
        }
        if (experienceRepository.count() == 0) {
            initializeExperiences();
        }
        if (testimonialRepository.count() == 0) {
            initializeTestimonials();
        }
        if (projectRepository.count() == 0) {
            initializeProjects();
        }
        if (certificateRepository.count() == 0) {
            initializeCertificates();
        }
    }
    
    private void initializeServices() {
        List<com.portfolio.entity.Service> services = Arrays.asList(
            new com.portfolio.entity.Service("Web Developer", "/web.png", 1),
            new com.portfolio.entity.Service("React Native Developer", "/mobile.png", 2),
            new com.portfolio.entity.Service("Backend Developer", "/backend.png", 3),
            new com.portfolio.entity.Service("Fullstack Developer", "/creator.png", 4)
        );
        serviceRepository.saveAll(services);
    }
    
    private void initializeTechnologies() {
        List<Technology> technologies = Arrays.asList(
            // Frontend Technologies
            new Technology("HTML 5", "/tech/html.png", 1),
            new Technology("CSS 3", "/tech/css.png", 2),
            new Technology("JavaScript", "/tech/javascript.png", 3),
            new Technology("TypeScript", "/tech/typescript-icon.svg", 4),
            new Technology("React JS", "/tech/react-icon.svg", 5),
            new Technology("Next.js", "/tech/nextjs.svg", 6),
            new Technology("Redux Toolkit", "/tech/redux.png", 7),
            new Technology("Tailwind CSS", "/tech/tailwind.png", 8),
            new Technology("Three JS", "/tech/threejs.svg", 9),
            new Technology("Vite", "/tech/vite.svg", 10),
            
            // Backend Technologies
            new Technology("Java", "/tech/java-icon.svg", 11),
            new Technology("Spring Boot", "/tech/spring-boot.svg", 12),
            new Technology("Python", "/tech/python.svg", 13),
            new Technology("Node JS", "/tech/nodejs-icon.svg", 14),
            new Technology("C++", "/tech/cpp-icon.svg", 15),
            
            // Databases
            new Technology("MySQL", "/tech/mysql-icon.svg", 16),
            new Technology("MongoDB", "/tech/mongodb-icon.svg", 17),
            new Technology("Redis", "/tech/redis.svg", 18),
            new Technology("PostgreSQL", "/tech/postgresql-icon.svg", 19),
            
            // Cloud & DevOps
            new Technology("AWS", "/tech/aws-icon.svg", 20),
            new Technology("Docker", "/tech/docker-icon.svg", 21),
            
            // Development Tools
            new Technology("Git", "/tech/git-icon.svg", 22),
            new Technology("GitHub", "/tech/github.svg", 23),
            new Technology("VS Code", "/tech/vscode.svg", 24),
            new Technology("Postman", "/tech/postman.svg", 25),
            new Technology("Figma", "/tech/figma-icon.svg", 26)
        );
        technologyRepository.saveAll(technologies);
    }
    
    private void initializeExperiences() {
        Experience exp1 = new Experience();
        exp1.setTitle("Full Stack Developer – NextHire");
        exp1.setCompany("MERN Hackathon");
        exp1.setDate("2025");
        exp1.setLocation("K L University");
        exp1.setLogo("/nexthire-icon.svg");
        exp1.setTechnologies(Arrays.asList("MongoDB", "Express", "React", "Node.js", "JWT", "Redux", "OpenAI API", "Framer Motion"));
        exp1.setPoints(Arrays.asList(
            "Built NextHire, an AI-powered recruitment platform with secure authentication and role-based access",
            "Added job posting, tracking, real-time chat, and AI modules for resume parsing and job matching.",
            "Designed a responsive, high-performance UI with React, Redux, and Framer Motion."
        ));
        exp1.setDisplayOrder(1);
        
        Experience exp2 = new Experience();
        exp2.setTitle("Frontend Developer – CodeSync (Collaborative Code Editor)");
        exp2.setCompany("PFSD Hackathon");
        exp2.setDate("2024");
        exp2.setLocation("K L University");
        exp2.setLogo("/codesync-icon.svg");
        exp2.setTechnologies(Arrays.asList("Python", "Django", "WebSockets", "SQL"));
        exp2.setPoints(Arrays.asList(
            "Built a real-time collaborative code editor using Django and WebSockets.",
            "Implemented multi-user editing, group chat, copilot and a compiler in it.",
            "Gained practical experience in software development and teamwork."
        ));
        exp2.setDisplayOrder(2);
        
        Experience exp3 = new Experience();
        exp3.setTitle("Full Stack Developer – Video Streaming Platform");
        exp3.setCompany("FSAD Hackathon");
        exp3.setDate("2024");
        exp3.setLocation("K L University");
        exp3.setLogo("/videostreaming-icon.svg");
        exp3.setTechnologies(Arrays.asList("Java", "Spring Boot", "MySQL", "REST API"));
        exp3.setPoints(Arrays.asList(
            "Developed a video streaming app with Spring Boot and MySQL.",
            "Led team coordination and implemented authentication features.",
            "Optimized database queries for performance."
        ));
        exp3.setDisplayOrder(3);
        
        Experience exp4 = new Experience();
        exp4.setTitle("Web Developer – HealthNest");
        exp4.setCompany("Smart India Hackathon");
        exp4.setDate("2023");
        exp4.setLocation("Vaddeswaram, Andhra Pradesh");
        exp4.setLogo("/healthnest-icon.svg");
        exp4.setTechnologies(Arrays.asList("HTML", "CSS", "Javascript", "C", "Data Structures", "Algorithms"));
        exp4.setPoints(Arrays.asList(
            "Gained practical experience through hackathons and coding competitions.",
            "Built a solid foundation in software development and programming.",
            "Collaborated on coding projects and team assignments."
        ));
        exp4.setDisplayOrder(4);
        
        experienceRepository.saveAll(Arrays.asList(exp1, exp2, exp3, exp4));
    }
    
    private void initializeTestimonials() {
        Testimonial testimonial1 = new Testimonial();
        testimonial1.setTestimonial("I thought it was impossible to make a website as beautiful as our product, but Rick proved me wrong.");
        testimonial1.setName("Sara Lee");
        testimonial1.setDesignation("CFO");
        testimonial1.setCompany("Acme Co");
        testimonial1.setImage("https://randomuser.me/api/portraits/women/4.jpg");
        testimonial1.setDisplayOrder(1);
        
        Testimonial testimonial2 = new Testimonial();
        testimonial2.setTestimonial("I've never met a web developer who truly cares about their clients' success like Rick does.");
        testimonial2.setName("Chris Brown");
        testimonial2.setDesignation("COO");
        testimonial2.setCompany("DEF Corp");
        testimonial2.setImage("https://randomuser.me/api/portraits/men/5.jpg");
        testimonial2.setDisplayOrder(2);
        
        Testimonial testimonial3 = new Testimonial();
        testimonial3.setTestimonial("After Rick optimized our website, our traffic increased by 50%. We can't thank them enough!");
        testimonial3.setName("Lisa Wang");
        testimonial3.setDesignation("CTO");
        testimonial3.setCompany("456 Enterprises");
        testimonial3.setImage("https://randomuser.me/api/portraits/women/6.jpg");
        testimonial3.setDisplayOrder(3);
        
        List<Testimonial> testimonials = Arrays.asList(testimonial1, testimonial2, testimonial3);
        testimonialRepository.saveAll(testimonials);
    }
    
    private void initializeProjects() {
        Project project1 = new Project();
        project1.setName("NextHire");
        project1.setDescription("Nexthire is an all-in-one job portal offering real-time chat, mock test preparation, and a suite of professional features to enhance both job searching and recruitment efficiency.");
        project1.setImage("/image.png");
        project1.setSourceCodeLink("https://github.com/its-pratyushpandey/NextHire.git");
        project1.setLiveLink("https://nexthireap.netlify.app/");
        project1.setDisplayOrder(1);
        project1 = projectRepository.save(project1);
        
        ProjectTag tag1_1 = new ProjectTag("react", "blue-text-gradient");
        tag1_1.setProject(project1);
        ProjectTag tag1_2 = new ProjectTag("nodejs", "green-text-gradient");
        tag1_2.setProject(project1);
        ProjectTag tag1_3 = new ProjectTag("tailwind", "pink-text-gradient");
        tag1_3.setProject(project1);
        ProjectTag tag1_4 = new ProjectTag("socket.io", "yellow-text-gradient");
        tag1_4.setProject(project1);
        
        project1.setTags(Arrays.asList(tag1_1, tag1_2, tag1_3, tag1_4));
        projectRepository.save(project1);
        
        Project project2 = new Project();
        project2.setName("Car Rent");
        project2.setDescription("Web-based platform that allows users to search, book, and manage car rentals from various providers, providing a convenient and efficient solution for transportation needs.");
        project2.setImage("/carrent.png");
        project2.setSourceCodeLink("https://github.com/");
        project2.setDisplayOrder(2);
        project2 = projectRepository.save(project2);
        
        ProjectTag tag2_1 = new ProjectTag("react", "blue-text-gradient");
        tag2_1.setProject(project2);
        ProjectTag tag2_2 = new ProjectTag("mongodb", "green-text-gradient");
        tag2_2.setProject(project2);
        ProjectTag tag2_3 = new ProjectTag("tailwind", "pink-text-gradient");
        tag2_3.setProject(project2);
        
        project2.setTags(Arrays.asList(tag2_1, tag2_2, tag2_3));
        projectRepository.save(project2);
        
        Project project3 = new Project();
        project3.setName("Trip Guide");
        project3.setDescription("A comprehensive travel booking platform that allows users to book flights, hotels, and rental cars, and offers curated recommendations for popular destinations.");
        project3.setImage("/tripguide.png");
        project3.setSourceCodeLink("https://github.com/");
        project3.setDisplayOrder(3);
        project3 = projectRepository.save(project3);
        
        ProjectTag tag3_1 = new ProjectTag("nextjs", "blue-text-gradient");
        tag3_1.setProject(project3);
        ProjectTag tag3_2 = new ProjectTag("supabase", "green-text-gradient");
        tag3_2.setProject(project3);
        ProjectTag tag3_3 = new ProjectTag("css", "pink-text-gradient");
        tag3_3.setProject(project3);
        
        project3.setTags(Arrays.asList(tag3_1, tag3_2, tag3_3));
        projectRepository.save(project3);
    }
    
    private void initializeCertificates() {
        Certificate certificate1 = new Certificate();
        certificate1.setTitle("Accenture Developer Virtual Experience");
        certificate1.setYear("2024");
        certificate1.setIssuer("Accenture");
        certificate1.setType("Other");
        certificate1.setImage("/accenture.png");
        certificate1.setVerifyLink("#");
        certificate1.setDisplayOrder(1);
        
        Certificate certificate2 = new Certificate();
        certificate2.setTitle("Aviatrix Certified Engineer (ACE) Multicloud Network Associate");
        certificate2.setYear("2024");
        certificate2.setIssuer("Aviatrix");
        certificate2.setType("Cloud");
        certificate2.setImage("/Aviatrix.png");
        certificate2.setVerifyLink("#");
        certificate2.setDisplayOrder(2);
        
        Certificate certificate3 = new Certificate();
        certificate3.setTitle("Salesforce Developer Virtual Internship");
        certificate3.setYear("2024");
        certificate3.setIssuer("Salesforce");
        certificate3.setType("Cloud");
        certificate3.setImage("/salesforce.png");
        certificate3.setVerifyLink("#");
        certificate3.setDisplayOrder(3);
        
        List<Certificate> certificates = Arrays.asList(certificate1, certificate2, certificate3);
        certificateRepository.saveAll(certificates);
    }
}