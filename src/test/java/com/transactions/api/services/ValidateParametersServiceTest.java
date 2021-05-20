package com.transactions.api.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class ValidateParametersServiceTest {

    @InjectMocks
    ValidateParametersService validateParametersService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenIdIsInRange_WhenCallValidate_ThenReturnTrue() {
        int id = 1500;
        // I prefer use the assertEquals because the log of error is explicit
        assertEquals(true, validateParametersService.isValidId(id));
    }

    @Test(expected = InvalidParameterException.class)
    public void givenIdIsLowerOfRange_WhenCallValidate_ThenShouldThrowAInvalidateParameterException() {
        int id = 999;
        validateParametersService.isValidId(id);
    }

    @Test(expected = InvalidParameterException.class)
    public void givenIdIsGreaterOfRange_WhenCallValidate_ThenShouldThrowAInvalidateParameterException() {
        int id = 100001;

        validateParametersService.isValidId(id);
    }

    @Test
    public void givenMonthIsInRange_WhenCallValidate_ThenReturnTrue() {
        int month = 8;
        // I prefer use the assertEquals because the log of error is explicit
        assertEquals(true, validateParametersService.isValidMonth(month));
    }

    @Test(expected = InvalidParameterException.class)
    public void givenMonthIsLowerOfRange_WhenCallValidate_ThenShouldThrowAInvalidateParameterException() {
        int month = 0;
        validateParametersService.isValidMonth(month);
    }

    @Test(expected = InvalidParameterException.class)
    public void givenMonthIsGreaterOfRange_WhenCallValidate_ThenShouldThrowAInvalidateParameterException() {
        int month = 13;

        validateParametersService.isValidMonth(month);
    }

    @Test
    public void givenYearIsInRange_WhenCallValidate_ThenReturnTrue() {
        int year = 8;
        // I prefer use the assertEquals because the log of error is explicit
        assertEquals(true, validateParametersService.isValidYear(year));
    }

    @Test(expected = InvalidParameterException.class)
    public void givenYearIsLowerOfRange_WhenCallValidate_ThenShouldThrowAInvalidateParameterException() {
        int year = -1;
        validateParametersService.isValidYear(year);
    }

    @Test(expected = InvalidParameterException.class)
    public void givenYearIsGreaterOfRange_WhenCallValidate_ThenShouldThrowAInvalidateParameterException() {
        int year = 0;

        validateParametersService.isValidYear(year);
    }
}