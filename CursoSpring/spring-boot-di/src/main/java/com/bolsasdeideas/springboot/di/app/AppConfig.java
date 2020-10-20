package com.bolsasdeideas.springboot.di.app;

import com.bolsasdeideas.springboot.di.app.models.service.IfServicio;
import com.bolsasdeideas.springboot.di.app.models.service.MiServicio;
import com.bolsasdeideas.springboot.di.app.models.service.MiServicioComplejo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    
    @Bean("miServicioSimple")
    public IfServicio registrarMiServicio() {
        return new MiServicio();
    }
    
    @Primary
    @Bean("miServicioComplejo")
    public IfServicio registrarMiServicioComplejo() {
        return new MiServicioComplejo();
    }
    
}
