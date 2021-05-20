package com.transactions.api.services;

import org.springframework.stereotype.Service;

@Service
public class CalculateNumberOfTransactionsService {

    public int getNumberOfTransactions(int id, int mes) {
        return getFirstIndex(id) * mes;
    }

    private int getFirstIndex(int number) {
        return Integer.parseInt(Character.toString(String.valueOf(number).charAt(0)));
    }
}
