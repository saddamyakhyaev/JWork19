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
public class NewProductCommandTest {

    String newproductCommand[];
    String expected;

    public NewProductCommandTest(String[] newproductCommand, String expected) {
        this.newproductCommand = newproductCommand;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{
                {new String[]{"iphone"}, "OK"},
                {new String[]{"iphone", "iphone"}, "ERROR"}
        });
    }


    @Test
    public void work() {
        System.out.println("Test: NewProductCommand work()");
        ProductsManager products = new ProductsManager();

        String result = "";
        for (int i = 0; i < newproductCommand.length; i++) {
            Command cm = new NewProductCommand(NewProductCommand.COMMNAME + " " + newproductCommand);
            result = cm.work(products);
        }

        assertEquals(expected, result);
    }
}