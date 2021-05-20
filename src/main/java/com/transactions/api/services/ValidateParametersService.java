package com.transactions.api.services;

import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
public class ValidateParametersService {

    private static final int START_RANGE_ID = 999;
    private static final int END_RANGE_ID = 100000;
    private static final int FIRST_MONTH = 1;
    private static final int LAST_MONTH = 12;

    public Boolean isValidId(int id) {
        if (id > START_RANGE_ID && id <= END_RANGE_ID) {
            return true;
        }
        throw new InvalidParameterException("The ID should be between 1.000 and 100.000");
    }

    public Boolean isValidMonth(int mes) {
        if (mes >= FIRST_MONTH && mes <= LAST_MONTH) {
            return true;
        }
        throw new InvalidParameterException("The month should be between 1 and 12");
    }

    public Boolean isValidYear(int ano) {
        if (ano > 0) {
            return true;
        }
        throw new InvalidParameterException("The year should be greater than 0");
    }
}
