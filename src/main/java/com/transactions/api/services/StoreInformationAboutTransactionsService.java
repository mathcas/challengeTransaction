package com.transactions.api.services;

import com.transactions.api.entities.Transaction;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class StoreInformationAboutTransactionsService {

    public void storeAllTransactions(List<Transaction> transactions, int mes, int id, int ano) {

        try {
            FileOutputStream fileOut = new FileOutputStream(formatFileName(mes, id, ano));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(transactions);
            out.close();
            fileOut.close();
        } catch (IOException ignored) {
        }
    }

    public List<Transaction> getStoredTransactions(int mes, int id, int ano) {
        try {
            FileInputStream fileIn = new FileInputStream(formatFileName(mes, id, ano));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            List<Transaction> transactions = (List<Transaction>) in.readObject();
            in.close();
            fileIn.close();
            return transactions;
        } catch (IOException | ClassNotFoundException a) {
            return null;
        }
    }

    private String formatFileName(int mes, int id, int ano) {
        return "transactionWithId" + id + "andWithMonth" + mes + "WithYear" + ano + ".ser";
    }
}
