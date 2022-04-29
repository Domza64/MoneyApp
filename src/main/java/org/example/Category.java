package org.example;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Transaction> transactions;

    public Category(String name) {
        this.name = name;
        transactions = new ArrayList<>();
    }

    public boolean addTransaction(Transaction transaction) {
        if (!transactions.contains(transaction)) {
            return transactions.add(transaction);
        }
        return false;
    }

    public boolean removeTransaction(Transaction transaction) {
        if (transactions.contains(transaction)) {
            return transactions.remove(transaction);
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return name;
    }
}
