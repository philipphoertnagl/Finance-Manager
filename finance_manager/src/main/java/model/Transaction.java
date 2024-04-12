package model;

import javafx.beans.property.*;

import java.time.LocalDateTime;

public class Transaction {

    private DoubleProperty amount;
    private ObjectProperty<LocalDateTime> date;
    private StringProperty name;


    public Transaction(double amount) {
        this.amount = new SimpleDoubleProperty(amount);
        this.date = new SimpleObjectProperty<>(LocalDateTime.now());
    }

    public Transaction(String name) {
        this.name = new SimpleStringProperty(name);
        this.amount = new SimpleDoubleProperty(0);
        this.date = new SimpleObjectProperty<>(LocalDateTime.now());
    }


    public Transaction() {

    }

    public double getAmount() {
        return amount.get();
    }

    public void editAmount(double amountToAdd) {
        double currentAmount = this.amount.get(); // Get the current amount
        this.amount.set(currentAmount + amountToAdd); // Set the new amount
        System.out.println("We transferred " + amountToAdd + " to the account at " + date);
    }

    public DoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    public LocalDateTime getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDateTime> dateProperty() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date.set(date);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String toString() {
        return "model.Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                '}';
    }
}//end
