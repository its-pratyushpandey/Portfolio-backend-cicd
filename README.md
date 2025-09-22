# Portfolio Backend API

A Spring Boot REST API for the portfolio application with MySQL database integration.

## Features

- RESTful API for portfolio data (services, technologies, experiences, projects, certificates)
- Contact form submission and storage
- MySQL database integration
- CORS support for frontend communication
- Data validation
- Auto-initialization of demo data

## Prerequisites

- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher

## Setup Instructions

### 1. Database Setup

1. Make sure MySQL is running
2. The application will automatically create the database `portfolio_db` if it doesn't exist
3. Default credentials are configured as:
   - Username: `root`
   - Password: `@Pratyush123`

### 2. Running the Application

```bash
# Navigate to the backend directory
cd backend

# Run the application using Maven
mvn spring-boot:run

# Or build and run the JAR
mvn clean package
java -jar target/portfolio-backend-0.0.1-SNAPSHOT.jar
```

The API will be available at: `http://localhost:8070/api`

### 3. API Endpoints

#### Portfolio Data
- `GET /api/portfolio/services` - Get all services
- `GET /api/portfolio/technologies` - Get all technologies
- `GET /api/portfolio/experiences` - Get all experiences
- `GET /api/portfolio/testimonials` - Get all testimonials
- `GET /api/portfolio/projects` - Get all projects
- `GET /api/portfolio/certificates` - Get all certificates

#### Contact
- `POST /api/portfolio/contact` - Submit contact form
- `GET /api/portfolio/contact/messages` - Get all contact messages (admin)

#### Health Check
- `GET /api/portfolio/health` - API health status

### 4. Configuration

You can modify the database configuration in `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/portfolio_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=@Pratyush123

# Server Configuration
server.port=8070
server.servlet.context-path=/api

# CORS Configuration
cors.allowed-origins=http://localhost:5173,http://localhost:3000,http://127.0.0.1:5173
```

### 5. Data Initialization

The application automatically populates the database with your portfolio data on first run. This includes:

- Services (Web Developer, React Native Developer, Backend Developer, Fullstack Developer)
- Technologies (HTML, CSS, JavaScript, React, Node.js, etc.)
- Experiences (NextHire, CodeSync, Video Streaming Platform, HealthNest)
- Sample testimonials
- Projects (NextHire, Car Rent, Trip Guide)
- Certificates (Accenture, Aviatrix, Salesforce)

### 6. Frontend Integration

Make sure your frontend makes requests to `http://localhost:8070/api/portfolio/` endpoints.

Example API calls from frontend:
```javascript
// Get all services
const response = await fetch('http://localhost:8070/api/portfolio/services');
const services = await response.json();

// Submit contact form
const response = await fetch('http://localhost:8070/api/portfolio/contact', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify({
        name: 'John Doe',
        email: 'john@example.com',
        message: 'Hello!'
    })
});
```

## Troubleshooting

### Database Connection Issues
1. Ensure MySQL is running
2. Verify the username and password in `application.properties`
3. Check if the database user has proper privileges

### CORS Issues
1. Make sure the frontend URL is added to the CORS configuration
2. Check the `CorsConfig.java` file for allowed origins

### Port Conflicts
1. If port 8080 is in use, change it in `application.properties`:
   ```properties
   server.port=8081
   ```

## Development

- The application uses Spring Boot DevTools for hot reloading during development
- Database schema is auto-updated using `spring.jpa.hibernate.ddl-auto=update`
- SQL queries are logged when `spring.jpa.show-sql=true`"# Portfolio-backend-cicd" 
