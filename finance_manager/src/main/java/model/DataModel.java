package model;

import service.DataStorage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class DataModel {
    private Category investments;
    private Category income;
    private Category costs;
    private Category savings;
    private DataStorage dataStorage = new DataStorage();
    private String filePath = "src/main/java/service/DataModel.json";
    private boolean isInitialized = false;
    private void initializeData() {
        if (!isInitialized) {
            System.out.println("Initializing data...");
            File file = new File(filePath);
            if (file.exists() && file.length() > 0) {
                try {
                    System.out.println("Loading model from file...");
                    DataModel loadedModel = dataStorage.loadDataModel(filePath);
                    if (loadedModel != null) {
                        this.investments = loadedModel.getInvestments();
                        this.income = loadedModel.getIncome();
                        this.costs = loadedModel.getCosts();
                        this.savings = loadedModel.getSavings();
                        System.out.println("Model loaded successfully.");
                    } else {
                        System.out.println("Loaded model is null, initializing empty categories.");
                        initializeEmptyCategories();
                    }
                } catch (Exception e) {
                    System.out.println("Failed to load model, initializing empty categories.");
                    e.printStackTrace();
                    initializeEmptyCategories();
                }
            } else {
                System.out.println("No existing data file, initializing empty categories.");
                initializeEmptyCategories();
            }
            isInitialized = true;
        }
    }



    private void initializeEmptyCategories() {
        investments = new Category("Investments", new ArrayList<>());
        income = new Category("Income", new ArrayList<>());
        costs = new Category("Costs", new ArrayList<>());
        savings = new Category("Savings", new ArrayList<>());
    }

    public void addSubCategory(Category category, SubCategory subCategory) {
        if (category == investments) {
            investments.addSubCategory(subCategory);
        } else if (category == income) {
            income.addSubCategory(subCategory);
        } else if (category == costs) {
            costs.addSubCategory(subCategory);
        } else if (category == savings) {
            savings.addSubCategory(subCategory);
        }
    }

    public void removeSubCategory(Category category, SubCategory subCategory) { //TODO: refactoring to a map
        if (category == investments) {
            investments.removeSubCategory(subCategory);
        } else if (category == income) {
            income.removeSubCategory(subCategory);
        } else if (category == costs) {
            costs.removeSubCategory(subCategory);
        } else if (category == savings) {
            savings.removeSubCategory(subCategory);
        }
    }


    public void loadData() {
      /*  //Investments subcateogires
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

        costs = new Category("Fixcosts per year", Arrays.asList(miete, energie, abos));*/




    }

    public Category getInvestments() {
        if (investments == null) {
            initializeData();  // Consider re-initializing or handle this more gracefully
        }
        return investments;
    }

    public Category getIncome() {
        if (income == null) {
            initializeData();  // Consider re-initializing or handle this more gracefully
        }
        return income;
    }

    public Category getCosts() {
        if (costs == null) {
            initializeData();  // Consider re-initializing or handle this more gracefully
        }
        return costs;
    }

    public Category getSavings() {
        if (savings == null) {
            initializeData();  // Consider re-initializing or handle this more gracefully
        }
        return savings;
    }

}