package product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class ProductsManagerTest {

    String[] newsProducts;
    TestClassProductSetting[] add;
    TestClassProductSetting[] demand;

    boolean add_expected;
    boolean demand_expected;


    public ProductsManagerTest(String[] newsProducts, TestClassProductSetting[] add, TestClassProductSetting[] demand, boolean add_expected, boolean demand_expected) {
        this.newsProducts = newsProducts;
        this.add = add;
        this.demand = demand;
        this.add_expected = add_expected;
        this.demand_expected = demand_expected;
    }

    @Parameterized.Parameters
    public static Collection numbers() {
        return Arrays.asList(new Object[][]{
                {
                    new String[]{"iphone"},
                    new TestClassProductSetting[]{
                                new TestClassProductSetting("iphone",2,1000,"23.01.2013"),
                                new TestClassProductSetting("iphone",1,6000,"29.01.2013")
                    },
                    new TestClassProductSetting[]{
                                new TestClassProductSetting("iphone",2,1000,"21.01.2013")
                    },
                        true, false
                },
                {
                        new String[]{"apple"},
                        new TestClassProductSetting[]{
                                new TestClassProductSetting("iphone",2,1000,"23.01.2013"),
                                new TestClassProductSetting("iphone",1,6000,"29.01.2013")
                        },
                        new TestClassProductSetting[]{
                                new TestClassProductSetting("iphone",2,1000,"21.01.2013")
                        },
                        false, false
                },
                {
                        new String[]{"iphone"},
                        new TestClassProductSetting[]{
                                new TestClassProductSetting("iphone",2,1000,"23.01.2013"),
                                new TestClassProductSetting("iphone",1,6000,"29.01.2013")
                        },
                        new TestClassProductSetting[]{
                                new TestClassProductSetting("iphone",10,1000,"21.03.2013")
                        },
                        true, false
                }

                });
    }

    @Test
    public void addProduct() {
        System.out.println("Test: DemandCommand work()");
        ProductsManager products = new ProductsManager();

        for(int i = 0; i < newsProducts.length; i++){
            products.newProduct(newsProducts[i]);
        }

        boolean result = false;
        for(int i = 0; i < add.length; i++){
            result = products.addProduct(add[i].getName(),add[i].getAmount(), add[i].getPrice(), add[i].getDate());
        }

        assertEquals(add_expected, result);
    }

    @Test
    public void demandProduct() {

        ProductsManager products = new ProductsManager();

        for(int i = 0; i < newsProducts.length; i++){
            products.newProduct(newsProducts[i]);
        }

        for(int i = 0; i < add.length; i++){
            products.addProduct(add[i].getName(),add[i].getAmount(), add[i].getPrice(), add[i].getDate());
        }

        boolean result = false;
        for(int i = 0; i < demand.length; i++){
            result = products.demandProduct(demand[i].getName(),demand[i].getAmount(), demand[i].getPrice(), demand[i].getDate());
        }

        assertEquals(demand_expected, result);
    }
}