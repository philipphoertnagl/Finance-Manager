import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class CategoryTest {

    private SubCategory immobilien = new SubCategory("Immobilien");
    private SubCategory gold = new SubCategory("Gold");
    private SubCategory fonds = new SubCategory("Aktien/Fonds");

    Category investments = new Category("Investments", Arrays.asList(immobilien, gold, fonds));
    @Test
    void testGetTotalCategoryAmount() {
        immobilien.addTransaction(new Transaction(1000));
        gold.addTransaction(new Transaction(2500));
        fonds.addTransaction(new Transaction(100));
        fonds.addTransaction(new Transaction(1000));

        assertEquals(4600, investments.getTotalAmount());


    }
}
