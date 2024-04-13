package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.*;

public class SubCategory {
    private StringProperty subName;
    private DoubleProperty amount;
    private List<Transaction> transactions;
    private ObjectProperty<LocalDate> date;

    public SubCategory(String name) {
        this.subName = new SimpleStringProperty(name);
        this.amount = new SimpleDoubleProperty(0);
        this.transactions = new ArrayList<>();
        this.date = new SimpleObjectProperty<>(LocalDate.now());
    }

    public SubCategory() {
        // Initialize all properties here to ensure they are not null
        this.subName = new SimpleStringProperty();
        this.amount = new SimpleDoubleProperty(0);
        this.transactions = new ArrayList<>();
        this.date = new SimpleObjectProperty<>(LocalDate.now());
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

    public void setSubName(String subName) {
        this.subName.set(subName);
    }

    public void setAmount(Double amount) {
        this.amount.set(amount);
    }


    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    @Override
    public String toString() {
        // Use getSubName() and getAmount() which return the actual values, not the Properties
        return getSubName() + ": $" + getAmount(); //for gettin the String value not String Property
    }

}
