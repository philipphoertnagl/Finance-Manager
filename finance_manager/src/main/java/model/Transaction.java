package model;

import java.time.LocalDateTime;

public class Transaction {

    private double amount;
    private LocalDateTime date;
    private String type;


    public Transaction(double amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public void editAmount(double amount) {
        this.amount += amount;
        System.out.println("We transferred " + amount + " to the account at " + date);

    }



    @Override
    public String toString() {
        return "model.Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                '}';
    }
}//end
