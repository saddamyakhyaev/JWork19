package commands;

import product.ProductsManager;

public class PurchaseCommand extends Command {

    public static final String COMMNAME = "PURCHASE";

    public PurchaseCommand(String settings) {
        super(settings);
    }

    public String work(ProductsManager products) {

        int amount = -1;
        int price = -1;


        if(getCountSetting() != 4) return errorWork();
        if(!products.isProduct(getSetting(1))) return errorWork();

        try{ amount = Integer.parseInt(getSetting(2)); }
        catch (NumberFormatException nfe) { return errorWork(); }

        if(amount <= 0) return errorWork();

        try{ price = Integer.parseInt(getSetting(3)); }
        catch (NumberFormatException nfe) { return errorWork(); }
        if(price <= 0) return errorWork();

        if(!idDateValid(getSetting(4))) { return errorWork();}

        if(!products.addProduct(getSetting(1), amount, price, getSetting(4))) return errorWork();

        return trueWork();
    }
}
