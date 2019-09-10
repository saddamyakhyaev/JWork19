package commands;

import product.ProductsManager;

public class NewProductCommand extends Command {

    public static final String COMMNAME = "NEWPRODUCT";

    public NewProductCommand(String setting) {
        super(setting);
    }

    public String work(ProductsManager products){

        if(getCountSetting() != 1) return errorWork();
        if(!products.newProduct(getSetting(1))) return errorWork();
        return trueWork();
    }

}
