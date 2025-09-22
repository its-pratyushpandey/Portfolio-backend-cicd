@echo off
echo ========================================
echo Portfolio Backend WAR Deployment Script
echo ========================================

set TOMCAT_HOME=C:\Program Files\Apache Software Foundation\Tomcat 9.0
set WEBAPPS_DIR=%TOMCAT_HOME%\webapps
set WAR_FILE=target\portfolio-backend.war
set SERVICE_NAME=Tomcat9

echo Checking if WAR file exists...
if not exist "%WAR_FILE%" (
    echo ❌ WAR file not found! Please build the project first with: mvn clean package
    exit /b 1
)

echo ✅ WAR file found: %WAR_FILE%

echo Stopping Tomcat service...
net stop "%SERVICE_NAME%" 2>nul
timeout /t 5 /nobreak

echo Removing existing deployment...
if exist "%WEBAPPS_DIR%\portfolio-backend" (
    echo Removing existing portfolio-backend directory...
    rmdir /s /q "%WEBAPPS_DIR%\portfolio-backend"
)

if exist "%WEBAPPS_DIR%\portfolio-backend.war" (
    echo Removing existing portfolio-backend.war...
    del "%WEBAPPS_DIR%\portfolio-backend.war"
)

echo Copying WAR file to Tomcat webapps...
copy "%WAR_FILE%" "%WEBAPPS_DIR%\" /Y

if %errorlevel% neq 0 (
    echo ❌ Failed to copy WAR file to Tomcat webapps directory!
    echo Please check if Tomcat is properly installed and the path is correct.
    exit /b 1
)

echo ✅ WAR file copied successfully

echo Starting Tomcat service...
net start "%SERVICE_NAME%"

if %errorlevel% neq 0 (
    echo ❌ Failed to start Tomcat service!
    echo Please start Tomcat manually or check the service configuration.
    exit /b 1
)

echo Waiting for deployment to complete...
timeout /t 30 /nobreak

echo ========================================
echo Deployment completed!
echo ========================================
echo Application URL: http://localhost:8080/portfolio-backend/
echo API Base URL: http://localhost:8080/portfolio-backend/api/portfolio/

echo Testing API connection...
timeout /t 10 /nobreak
curl -f http://localhost:8080/portfolio-backend/api/portfolio/services 2>nul
if %errorlevel% equ 0 (
    echo ✅ API is responding correctly!
) else (
    echo ⚠️  API not responding yet. Check Tomcat logs for details.
    echo Logs location: %TOMCAT_HOME%\logs\catalina.out
)

echo ========================================
pause