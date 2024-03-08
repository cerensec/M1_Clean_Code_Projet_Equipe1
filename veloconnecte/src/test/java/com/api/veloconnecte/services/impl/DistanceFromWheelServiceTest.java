package com.api.veloconnecte.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.poc.IWheel;

class DistanceFromWheelServiceTest {
    
    IWheel mockWheel = new IWheel() {
        @Override
        public double getDiameteres() {
            return 10.0;
        }
    };
    
    DistanceFromWheelService distanceService = new DistanceFromWheelService();

    @BeforeAll
    static void setUpBeforeClass() throws Exception {}

    @AfterAll
    static void tearDownAfterClass() throws Exception {}

    @BeforeEach
    void setUp() throws Exception {}

    @AfterEach
    void tearDown() throws Exception {}

    @Test
    void testCalculateDistanceInMeters() {
        // Arrange
        double delta = 0.0001;

        // Act
        double result = distanceService.calculateDistanceInMeters(mockWheel, 5);

        // Assert
        assertEquals(Math.PI * 10.0 * 5, result, delta);
    }

}
