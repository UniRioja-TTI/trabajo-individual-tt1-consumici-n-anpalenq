package com.tt1.servicios;

import modelo.Destinatario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import servicios.*;

class EnviarEmailsImplTest {

    private EnviarEmailsImpl service;
    private Logger logger = LoggerFactory.getLogger(EnviarEmailsImplTest.class);

    @BeforeEach
    void setUp() {
        // Creamos el servicio con el logger
        service = new EnviarEmailsImpl(logger);
    }

    @Test
    void serviceIsCreated() {
        // Comprobamos que el servicio se ha creado correctamente
        assertNotNull(service);
    }

    @Test
    void enviarEmailReturnsTrue() {
        // Solo comprobamos que el método devuelve true
        Destinatario dest = new Destinatario(); 
        boolean result = service.enviarEmail(dest, "Contenido de prueba");
        assertTrue(result);
    }
}