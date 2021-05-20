package com.transactions.api.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class CreateValueServiceTest {

    @InjectMocks
    CreateValueService createValueService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenId100000AndFinalValueGreaterThan99999999_WhenTryCalculateNumber_ThenReturnANumberLowerThan() {
        int id = 100000;
        int mes = 12;
        int index = 100;
        // I prefer use the assertEquals because the log of error is explicit
        assertEquals(1_200_000, createValueService.createValue(mes, id, index));
    }

    @Test
    public void givenSmallNumbers_WhenTryCalculateNumber_ThenReturnANumber() {
        int id = 1000;
        int mes = 12;
        int index = 3;

        assertEquals(36_000, createValueService.createValue(mes, id, index));
    }
}