package org.example;

public class Transaction {
    private String description;
    private double amount;

    public Transaction(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public Transaction(double amount) {
        this(amount, "");
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return amount + ": " + description;
    }
}
