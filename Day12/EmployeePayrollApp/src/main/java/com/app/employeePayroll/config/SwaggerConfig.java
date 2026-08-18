package com.app.employeePayroll.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI employeePayrollOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Payroll API")
                        .description("API documentation for Employee and Department management system")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Harsh Vardhan")
                                .email("hrshvardhan@proton.me")
                                .url("https://harshvardhanportfolio.me")));
    }
}
