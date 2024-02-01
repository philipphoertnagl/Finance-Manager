package model;

import java.util.Arrays;

public class DataModel {
    private Category investments;
    private Category income;
    private Category costs;
    private Category savings;


    public void loadData() {
        SubCategory immobilien = new SubCategory("Immobilien");
        SubCategory gold = new SubCategory("Gold");
        SubCategory fonds = new SubCategory("Aktien/Fonds");
        SubCategory crypto = new SubCategory("Crypto");

        investments = new Category("Investments", Arrays.asList(immobilien, gold, fonds, crypto));

        SubCategory workA = new SubCategory("iT");
        SubCategory workB = new SubCategory("LP");
        SubCategory sonstiges = new SubCategory("Sonstiges");

        income = new Category("Income", Arrays.asList(workA, workB, sonstiges));

        SubCategory miete = new SubCategory("Miete");
        SubCategory energie = new SubCategory("Energie");
        SubCategory abos = new SubCategory("Abos");

        costs = new Category("Fixcosts per year", Arrays.asList(miete, energie, abos));

        SubCategory bankA = new SubCategory("Dad");
        SubCategory bankB = new SubCategory("Ra");
        SubCategory bankC = new SubCategory("Ng");
        SubCategory cash = new SubCategory("Cash");

        savings = new Category("Savings", Arrays.asList(bankA, bankB, bankC, cash));

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