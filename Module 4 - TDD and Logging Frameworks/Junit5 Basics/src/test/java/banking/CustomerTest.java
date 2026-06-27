package banking;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


public class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setUp() throws Exception {
         customer = new Customer("Mabud", 21, "mdmabud2005@gmail.com", new BigDecimal(12000), "Savings");
    }

    @AfterEach
    public void tearDown() throws Exception {
        customer = null;
    }

    @Test
    public void testToString() {
        // Arrange
        String expectedName = "Mabud";

        // Act
        String actualName = customer.toString();

        // Assert
        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    public void withdraw() {
        // Arrange
        BigDecimal withdrawAmount = new BigDecimal("2000");
        BigDecimal expectedBalance = new BigDecimal("10000");

        // Act
        customer.withdraw(withdrawAmount);
        BigDecimal actualBalance = customer.getBalance();

        // Assert
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void deposit() {
        // Arrange
        BigDecimal depositAmount = new BigDecimal("2000");
        BigDecimal expectedBalance = new BigDecimal("14000");

        // Act
        customer.deposit(depositAmount);
        BigDecimal actualBalance = customer.getBalance();

        // Assert
        Assertions.assertEquals(expectedBalance, actualBalance);
    }
}