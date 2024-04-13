package model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {

    private DoubleProperty amount;
    private ObjectProperty<LocalDate> date;
    private StringProperty name;



    public Transaction(String name) {
        this.name = new SimpleStringProperty(name);
        this.amount = new SimpleDoubleProperty(0);
        this.date = new SimpleObjectProperty<>(LocalDate.now());
    }

    public Transaction(double amount) {
        this.name = new SimpleStringProperty();
        this.amount = new SimpleDoubleProperty(amount);
        this.date = new SimpleObjectProperty<>(LocalDate.now());
    }



    public Transaction() {
        this.name = new SimpleStringProperty();
        this.amount = new SimpleDoubleProperty();
        this.date = new SimpleObjectProperty<>(LocalDate.now());
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

    public LocalDate getDate() {
        return date.get();
    }

    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }

    public void setDate(LocalDate date) {
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
