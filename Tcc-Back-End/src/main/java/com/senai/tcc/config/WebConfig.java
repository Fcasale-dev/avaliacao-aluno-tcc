package com.senai.tcc.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permite CORS de http://127.0.0.1:5500 para todas as rotas
        registry.addMapping("/**")  // Permite todas as rotas
                .allowedOrigins("http://127.0.0.1:5500")  // Permite requisições dessa origem
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Permite os métodos HTTP especificados
                .allowedHeaders("*");  // Permite qualquer cabeçalho
    }
}