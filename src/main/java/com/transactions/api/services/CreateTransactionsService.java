package com.transactions.api.services;

import com.transactions.api.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateTransactionsService {

    @Autowired
    CalculateNumberOfTransactionsService calculateNumberOfTransactionsService;

    @Autowired
    CreateDateOnTimestampFormatService createDateOnTimestampFormatService;

    @Autowired
    CreateDescriptionsService createDescriptionsService;

    @Autowired
    CreateValueService createValueService;

    @Autowired
    StoreInformationAboutTransactionsService storeInformationAboutTransactionsService;

    public List<Transaction> getTransactions(int id, int mes, int ano) {
        int numberOfTransactions = calculateNumberOfTransactionsService.getNumberOfTransactions(id, mes);
        List<Transaction> transactions = storeInformationAboutTransactionsService.getStoredTransactions(mes, id, ano);

        if (transactions != null) {
            return transactions;
        }
        transactions = new ArrayList();
        for (int i = 0; i < numberOfTransactions; i++) {
            Transaction tr = new Transaction();
            tr.setData(createDateOnTimestampFormatService.getDate(ano, mes));
            tr.setDescricao(createDescriptionsService.getDescription());
            tr.setValor(createValueService.createValue(mes, id, i));
            transactions.add(tr);
        }

        storeInformationAboutTransactionsService.storeAllTransactions(transactions, mes, id, ano);
        return transactions;
    }
}
