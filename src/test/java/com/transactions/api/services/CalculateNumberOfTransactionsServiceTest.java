package com.transactions.api.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class CalculateNumberOfTransactionsServiceTest {

    @InjectMocks
    CalculateNumberOfTransactionsService calculateNumber;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenMonth2AndId1000_WhenTryCalculateNumber_ThenReturn2() {
        int id = 1000;
        int mes = 2;
        // I prefer use the assertEquals because the log of error is explicit
        assertEquals(2, calculateNumber.getNumberOfTransactions(id, mes));
    }

    @Test
    public void givenMonth12AndId100000_WhenTryCalculateNumber_ThenReturn2() {
        int id = 100000;
        int mes = 12;
        assertEquals(12, calculateNumber.getNumberOfTransactions(id, mes));
    }

}