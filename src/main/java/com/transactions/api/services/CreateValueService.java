package com.transactions.api.services;

import org.springframework.stereotype.Service;

@Service
public class CreateValueService {

    public int createValue(int mes, int id, int index) {
        int value = mes * id * index;
        while (value > 9999999) value = value / 10;
        return value;
    }
}
