package model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    protected final String name;
    protected List<SubCategory> subCategories;


    public Category(String name, List<SubCategory> subCategories) {
        this.name = name;
        this.subCategories = new ArrayList<>(subCategories);
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (SubCategory subCategory : subCategories) {
            totalAmount += subCategory.getAmount();
        }
        return totalAmount;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public String getName() {
        return name;
    }

    public void addSubCategory(SubCategory subCategory) {
        this.subCategories.add(subCategory);
    }

    public void removeSubCategory(SubCategory subCategory) {
        this.subCategories.remove(subCategory);
    }

    @Override
    public String toString() {
        return "model.Category{" +
                "name='" + name + '\'' +
                ", subCategories=" + subCategories +
                '}';
    }
}// end
