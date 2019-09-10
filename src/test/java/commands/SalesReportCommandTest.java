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
public class SalesReportCommandTest {

    String newproductCommand;
    String[] purchaseCommand;
    String[] demandCommand;
    String salesReportCommand;
    String expected;

    public SalesReportCommandTest(String newproductCommand, String[] purchaseCommand, String[] demandCommand, String salesReportCommand, String expected) {
        this.newproductCommand = newproductCommand;
        this.purchaseCommand = purchaseCommand;
        this.demandCommand = demandCommand;
        this.salesReportCommand = salesReportCommand;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{
                {"iphone", new String[]{"iphone 1 1000 01.01.2017","iphone 2 2000 01.02.2017"}, new String[]{"iphone 2 5000 01.03.2017"}, "iphone 02.03.2017", "7000"},
                {"apple", new String[]{"apple 3 900 01.01.2017","apple 2 800 01.02.2017"}, new String[]{"apple 2 4000 09.03.2017"}, "home 02.05.2016", "ERROR"},
                {"apple", new String[]{"apple 3 900 01.01.2017","apple 2 800 01.02.2017"}, new String[]{"apple 2 4000 09.03.2017"}, "apple 02.05.2016", "0"}
        });
    }

    @Test
    public void work() {

        System.out.println("Test: SalesReportCommand work()");
        ProductsManager products = new ProductsManager();


        Command cm = new NewProductCommand(NewProductCommand.COMMNAME + " " + newproductCommand);
        cm.work(products);

        for(int i = 0; i < purchaseCommand.length; i++) {
            cm = new PurchaseCommand(PurchaseCommand.COMMNAME + " " + purchaseCommand[i]);
            cm.work(products);
        }

        for(int i = 0; i < demandCommand.length; i++) {
            cm = new DemandCommand(DemandCommand.COMMNAME + " " + demandCommand[i]);
            cm.work(products);
        }

        cm = new SalesReportCommand(SalesReportCommand.COMMNAME + " " + salesReportCommand);
        String result = cm.work(products);


        assertEquals(expected, result);
    }


}