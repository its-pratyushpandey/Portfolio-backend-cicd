# Portfolio Backend Setup Guide

## Complete Setup Instructions

### Prerequisites Installation

1. **Install Java 17 (if not already installed)**
   - Download from: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
   - Or use OpenJDK: https://jdk.java.net/17/
   - Verify installation: `java -version`

2. **Install Maven (if not already installed)**
   - Download from: https://maven.apache.org/download.cgi
   - Add Maven to your system PATH
   - Verify installation: `mvn -version`

3. **Install MySQL 8.0+**
   - Download from: https://dev.mysql.com/downloads/mysql/
   - During installation, set root password to: `@Pratyush123`
   - Start MySQL service
   - Verify installation by opening MySQL Workbench or command line

### Database Setup

1. **Start MySQL Service**
   - Windows: Start MySQL80 service from Services
   - Or use MySQL Workbench

2. **Verify Database Connection**
   - Open MySQL Workbench or MySQL Command Line Client
   - Connect with username: `root` and password: `@Pratyush123`
   - The application will automatically create the `portfolio_db` database

### Running the Backend

1. **Option 1: Using the batch file (Recommended)**
   ```cmd
   double-click on start-backend.bat
   ```

2. **Option 2: Using Command Line**
   ```cmd
   cd "c:/Users/praty/OneDrive/Desktop/ci cd portfolio/backend"
   mvn spring-boot:run
   ```

3. **Option 3: Using IDE**
   - Open the backend folder in your IDE (IntelliJ IDEA, Eclipse, VS Code)
   - Run the `PortfolioBackendApplication.java` file

### Verification

1. **Check if the backend is running**
   - Open browser and go to: http://localhost:8080/api/portfolio/health
   - You should see: `{"status":"OK","message":"Portfolio Backend API is running"}`

2. **Test API endpoints**
   - Services: http://localhost:8080/api/portfolio/services
   - Technologies: http://localhost:8080/api/portfolio/technologies
   - Experiences: http://localhost:8080/api/portfolio/experiences
   - Projects: http://localhost:8080/api/portfolio/projects
   - Certificates: http://localhost:8080/api/portfolio/certificates

### Common Issues and Solutions

#### Issue 1: MySQL Connection Failed
- **Error**: `Communications link failure`
- **Solution**: 
  - Ensure MySQL service is running
  - Check username/password in `application.properties`
  - Verify MySQL is running on port 3306

#### Issue 2: Port 8080 already in use
- **Error**: `Port 8080 was already in use`
- **Solution**: 
  - Change port in `application.properties`: `server.port=8081`
  - Or stop the service using port 8080

#### Issue 3: Java/Maven not found
- **Error**: `'java' is not recognized` or `'mvn' is not recognized`
- **Solution**: 
  - Add Java and Maven to your system PATH
  - Restart command prompt after adding to PATH

### Next Steps - Frontend Integration

Once the backend is running, you can integrate it with your frontend by:

1. **Update your frontend to use the backend API**
   - Replace static data imports with API calls
   - Example for services:
   ```javascript
   // Instead of: import { services } from "../constants";
   // Use:
   const [services, setServices] = useState([]);
   
   useEffect(() => {
     fetch('http://localhost:8080/api/portfolio/services')
       .then(response => response.json())
       .then(data => setServices(data));
   }, []);
   ```

2. **Update the contact form**
   - Replace EmailJS with backend API call
   ```javascript
   const response = await fetch('http://localhost:8080/api/portfolio/contact', {
     method: 'POST',
     headers: {
       'Content-Type': 'application/json',
     },
     body: JSON.stringify(formData)
   });
   ```

### API Documentation

All endpoints are prefixed with `/api/portfolio/`:

- **GET** `/services` - Get all services
- **GET** `/technologies` - Get all technologies  
- **GET** `/experiences` - Get all experiences
- **GET** `/testimonials` - Get all testimonials
- **GET** `/projects` - Get all projects
- **GET** `/certificates` - Get all certificates
- **POST** `/contact` - Submit contact form
- **GET** `/health` - Health check

### Support

If you encounter any issues:
1. Check the console output for error messages
2. Verify MySQL connection
3. Ensure all prerequisites are installed
4. Check firewall/antivirus settings if needed