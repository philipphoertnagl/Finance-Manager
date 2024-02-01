import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    private Transaction transaction;
    private final double initialAmount = 1000.0;

    @BeforeEach
    void setUp() {
        transaction = new Transaction(initialAmount);
    }
    @Test
    void testGetAmount() {
        double actualAmount = transaction.getAmount();

        //Assert
        assertEquals(initialAmount, actualAmount);

    }

    @Test
    void testAddPositiveAmount() {
        double positiveAmount = 500;

        transaction.editAmount(positiveAmount);
        double actualAmount = transaction.getAmount();

        assertEquals(initialAmount + positiveAmount, actualAmount);
    }

    @Test
    void testAddNegativeAmount() {
        double negativeAmount = -400;
        transaction.editAmount(negativeAmount);
        double actualAmount = transaction.getAmount();

        assertEquals(initialAmount + negativeAmount, actualAmount);
    }

}