package commands;

import product.ProductsManager;

public class CloseCommand extends Command {
    public static final String COMMNAME = "CLOSE";

    public CloseCommand(String settings) {
        super(settings);
    }

    public String work(ProductsManager products) {
        this.close();
        return trueWork();
    }

}
