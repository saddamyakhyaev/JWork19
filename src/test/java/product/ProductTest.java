package product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ProductTest {

    String[] newProductCommand;
    String name;

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{
                {new String[]{"apple","iphone", "nokia"}, "iphone"}
        });
    }

    @Test
    public void getId() {
        System.out.println("Test: DemandCommand work()");
    }
}