package commands;

import org.junit.Test;
import product.ProductsManager;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CloseCommandTest {

    @Test
    public void work() {

        System.out.println("Test: DemandCommand work()");
        ProductsManager products = new ProductsManager();

        Command cm = new CloseCommand(CloseCommand.COMMNAME);
        String result = cm.work(products);
        String expected = "OK";

        assertEquals(expected, result);
    }
}