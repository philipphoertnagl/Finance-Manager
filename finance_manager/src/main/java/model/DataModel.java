package model;

import java.util.Arrays;

public class DataModel {
    private Category investments;
    private Category income;
    private Category costs;
    private Category savings;


    public void loadData() {
        //Investments subcateogires
        SubCategory immobilien = new SubCategory("Immobilien");
        SubCategory gold = new SubCategory("Gold");
        SubCategory fonds = new SubCategory("Aktien/Fonds");
        SubCategory crypto = new SubCategory("Crypto");

        gold.addTransaction(new Transaction(4000));
        gold.addTransaction(new Transaction(300));
        crypto.addTransaction(new Transaction(1200));
        immobilien.addTransaction(new Transaction(120000));

        investments = new Category("Investments", Arrays.asList(immobilien, gold, fonds, crypto));


        //SAVINGS subcategories
        SubCategory bankA = new SubCategory("Dad");
        SubCategory bankB = new SubCategory("Ra");
        SubCategory bankC = new SubCategory("Ng");
        SubCategory cash = new SubCategory("Cash");

        bankA.addTransaction(new Transaction(3000));
        bankB.addTransaction(new Transaction(1000));
        bankC.addTransaction(new Transaction(5000));
        cash.addTransaction(new Transaction(7330));

        savings = new Category("Savings", Arrays.asList(bankA, bankB, bankC, cash));



        //INCOME subcategories
        SubCategory workA = new SubCategory("iT");
        SubCategory workB = new SubCategory("LP");
        SubCategory sonstiges = new SubCategory("Sonstiges");

        workA.addTransaction(new Transaction(600));
        workB.addTransaction(new Transaction(900));

        income = new Category("Income", Arrays.asList(workA, workB, sonstiges));


        //FIXCOSTS subcategories
        SubCategory miete = new SubCategory("Miete");
        SubCategory energie = new SubCategory("Energie");
        SubCategory abos = new SubCategory("Abos");

        miete.addTransaction(new Transaction(800));
        energie.addTransaction(new Transaction(150));
        abos.addTransaction(new Transaction(32));

        costs = new Category("Fixcosts per year", Arrays.asList(miete, energie, abos));




    }

    public Category getInvestments() {
        return investments;
    }

    public Category getIncome() {
        return income;
    }

    public Category getCosts() {
        return costs;
    }

    public Category getSavings() {
        return savings;
    }

}