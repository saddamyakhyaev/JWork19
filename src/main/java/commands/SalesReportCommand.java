package commands;

import product.AddProduct;
import product.ProductsManager;

import java.util.ArrayList;

public class SalesReportCommand extends Command {

    public static final String COMMNAME = "SALESREPORT";

    public SalesReportCommand(String settings) {
        super(settings);
    }

    public String work(ProductsManager products) {

        if(getCountSetting() != 2) return errorWork();
        if(!products.isProduct(getSetting(1))) return errorWork();
        if(!idDateValid(getSetting(2))) { return errorWork();}

        ArrayList<AddProduct> demandProducts = products.getDemandProducts(getSetting(1), getSetting(2));

        int purchasePrice = 0;
        int demandPrice = 0;
        for (int i = 0; i < demandProducts.size(); i++) {
            purchasePrice += demandProducts.get(i).getPrice();
            demandPrice += demandProducts.get(i).getPriceDemand();
        }
        return "" + (demandPrice - purchasePrice);
    }
}
