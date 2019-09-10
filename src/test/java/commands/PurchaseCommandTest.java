package commands;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import product.ProductsManager;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class PurchaseCommandTest {

    String newproductCommand;
    String purchaseCommand;
    String expected;

    @Parameterized.Parameters
    public static Collection numbers(){
        return Arrays.asList(new Object[][]{
                {"iphone","iphone 1 1000 01.01.2017", "OK"},
                {"iphone","apple 1 1000 01.01.2017", "ERROR"},
                {"apple","apple 2 0 01.01.2017", "ERROR"},
                {"apple","apple 2 100 01.01.2017", "OK"}
        });
    }

    public PurchaseCommandTest(String newproductCommand, String purchaseCommand, String expected) {
        this.newproductCommand = newproductCommand;
        this.purchaseCommand = purchaseCommand;
        this.expected = expected;
    }

    @Test
    public void work() {
        System.out.println("Test: PurchaseCommand work()");
        ProductsManager products = new ProductsManager();


        Command cm = new NewProductCommand(NewProductCommand.COMMNAME + " " + newproductCommand);
        cm.work(products);

        cm = new PurchaseCommand(PurchaseCommand.COMMNAME + " " + purchaseCommand);
        String result = cm.work(products);

        assertEquals(expected, result);
    }


}