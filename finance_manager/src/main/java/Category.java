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


    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", subCategories=" + subCategories +
                '}';
    }
}// end
