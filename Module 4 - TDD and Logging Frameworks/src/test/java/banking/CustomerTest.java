package banking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
         customer = new Customer("Mabud", 21, "mdmabud2005@gmail.com", new BigDecimal(12000), "Savings");
    }

    @After
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
        assertEquals(expectedName, actualName);
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
        assertEquals(expectedBalance, actualBalance);
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
        assertEquals(expectedBalance, actualBalance);
    }
}