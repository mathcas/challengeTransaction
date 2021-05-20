package com.transactions.api.controllers;

import com.transactions.api.entities.Transaction;
import com.transactions.api.services.CreateTransactionsService;
import com.transactions.api.services.ValidateParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
public class TransactionsControllers {

    @Autowired
    ValidateParametersService validateParametersService;

    @Autowired
    CreateTransactionsService createTransactionsService;

    @GetMapping(value = "/{id}/transacoes/{ano}/{mes}")
    public ResponseEntity<List<Transaction>> getEnterprise(@PathVariable("id") int id, @PathVariable("ano") int ano, @PathVariable("mes") int mes) {
        List<Transaction> list = new ArrayList<Transaction>();
        if (validateParametersService.isValidId(id) && validateParametersService.isValidMonth(mes) && validateParametersService.isValidYear(ano)) {
            list = createTransactionsService.getTransactions(id, mes, ano);
        }
        return ResponseEntity.ok(list);
    }
}
