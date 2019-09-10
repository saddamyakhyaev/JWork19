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
public class DemandCommandTest {

    String newproductCommand;
    String[] purchaseCommand;
    String[] demandCommand;
    String expected;

    public DemandCommandTest(String newproductCommand, String[] purchaseCommand, String[] demandCommand, String expected) {
        this.newproductCommand = newproductCommand;
        this.purchaseCommand = purchaseCommand;
        this.demandCommand = demandCommand;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{
                {"iphone", new String[]{"iphone 1 1000 01.01.2017","iphone 2 2000 01.02.2017"}, new String[]{"iphone 2 5000 01.03.2017"}, "OK"},
                {"iphone", new String[]{"iphone 1 1000 01.01.2017","iphone 2 2000 01.02.2017"}, new String[]{"iphone 4 5000 01.03.2017"}, "ERROR"},
                {"iphone", new String[]{"iphone 1 1000 01.01.2017","iphone 2 2000 01.02.2017"}, new String[]{"iphone 2 0 01.03.2017"}, "ERROR"}
        });
    }

    @Test
    public void work() {

        System.out.println("Test: DemandCommand work()");
        ProductsManager products = new ProductsManager();


        Command cm = new NewProductCommand(NewProductCommand.COMMNAME + " " + newproductCommand);
        cm.work(products);

        for(int i = 0; i < purchaseCommand.length; i++) {
            cm = new PurchaseCommand(PurchaseCommand.COMMNAME + " " + purchaseCommand[i]);
            cm.work(products);
        }

        String result = "";
        for(int i = 0; i < demandCommand.length; i++) {
            cm = new DemandCommand(DemandCommand.COMMNAME + " " + demandCommand[i]);
            result = cm.work(products);
        }


        assertEquals(expected, result);
    }



}