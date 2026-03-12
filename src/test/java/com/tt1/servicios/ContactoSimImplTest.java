package com.tt1.servicios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import servicios.*;

class ContactoSimImplTest {

    private ContactoSimImpl service;

    @BeforeEach
    void setUp() {
        service = new ContactoSimImpl();
    }

    @Test
    void serviceIsCreated() {
        assertNotNull(service);
    }

    @Test
    void solicitarSimulationReturnsMinusOneByDefault() {
        assertEquals(-1, service.solicitarSimulation(null));
    }

    @Test
    void getEntitiesReturnsEmptyList() {
        assertTrue(service.getEntities().isEmpty());
    }

    @Test
    void isValidEntityIdReturnsFalseByDefault() {
        assertFalse(service.isValidEntityId());
    }
}