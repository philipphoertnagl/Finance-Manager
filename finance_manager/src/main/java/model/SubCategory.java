package model;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SubCategory {
    private StringProperty subName;
    private DoubleProperty amount;
    private List<Transaction> transactions;

    public SubCategory(String name) {
        this.subName = new SimpleStringProperty(name);
        this.amount = new SimpleDoubleProperty(0);
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        this.amount.set(this.amount.get() + transaction.getAmount());
    }

    public double getAmount() {
        return amount.get();
    }

    public DoubleProperty amountProperty() {
        return amount;
    }

    public String getSubName() {
        return subName.get();
    }

    public StringProperty subNameProperty() {
        return subName;
    }

    @Override
    public String toString() {
        // Customize this method to output what you want to show in the ListView
        return subName + ": $" + getAmount();
    }
}
