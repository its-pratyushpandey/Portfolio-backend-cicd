package com.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driver-class-name=org.h2.Driver",
    "spring.jpa.hibernate.ddl-auto=create-drop", 
    "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect",
    "portfolio.data.initialization.enabled=false"
})
class PortfolioBackendApplicationTests {

    @Test
    void contextLoads() {
        // This test ensures that the Spring context loads successfully
    }

}