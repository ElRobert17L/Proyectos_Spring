package com.bolsasdeideas.springboot.di.app.models.service;

import org.springframework.stereotype.Component;

//@Component("miServicioComplejo")
public class MiServicioComplejo implements IfServicio{

    @Override
    public String operacion() {
        return "ejecutando algún proceso complejo...";
    }
}
