@echo off
echo Starting Portfolio Backend with H2 Database (for testing)...
echo.

REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Error: Java is not installed or not in PATH
    echo Please install Java 17 or higher and try again
    pause
    exit /b 1
)

REM Check if Maven is installed
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Error: Maven is not installed or not in PATH
    echo Please install Maven and try again
    pause
    exit /b 1
)

echo Java and Maven are installed. Starting the application with H2 database...
echo.
echo The API will be available at: http://localhost:8070/api
echo H2 Console will be available at: http://localhost:8070/api/h2-console
echo Press Ctrl+C to stop the application
echo.

REM Run the Spring Boot application with H2 profile
mvn spring-boot:run -Dspring-boot.run.profiles=h2

pause