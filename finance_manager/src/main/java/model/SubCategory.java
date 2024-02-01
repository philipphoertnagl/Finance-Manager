package model;

import java.util.ArrayList;
import java.util.List;

public class SubCategory {
    private final String subName;
    private double amount;
    private List<Transaction> transactions;

    public SubCategory(String name) {
        this.subName = name;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        this.amount += transaction.getAmount();
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        // Customize this method to output what you want to show in the ListView
        return subName + ": $" + getAmount();
    }
}
