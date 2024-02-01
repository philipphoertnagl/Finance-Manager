import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SubCategory immobilien = new SubCategory("Immobilien");
        SubCategory gold = new SubCategory("Gold");
        SubCategory fonds = new SubCategory("Aktien/Fonds");

        immobilien.addTransaction(new Transaction(300));
        immobilien.addTransaction(new Transaction(700));

        gold.addTransaction(new Transaction(2100));
        gold.addTransaction(new Transaction(1800));
        gold.addTransaction(new Transaction(2200));
        System.out.println(gold.getAmount());
        gold.addTransaction(new Transaction(-6000));
        System.out.println(gold.getAmount());



        Category investments = new Category("Investments", Arrays.asList(immobilien, gold, fonds));
        System.out.println(investments);
        System.out.println(investments.getTotalAmount());
    }


}
