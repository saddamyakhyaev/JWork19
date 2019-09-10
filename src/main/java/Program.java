import commands.*;
import product.ProductsManager;

import java.util.Scanner;

public class Program {

    ProductsManager products;

    public Program() {
        products = new ProductsManager();
    }

    public int on(){

        Scanner scanner = new Scanner(System.in);

        while (true){
            String string = scanner.nextLine();
            Command cm = choiceCommand(string);

            if(cm != null){
                System.out.println(cm.work(this.products));
                if(cm.isClose()) break;
            }
        }
        return 1;
    }


    public Command choiceCommand(String setting){
        String[] words = setting.split(" ");
        if(words.length == 0) return null;
        Command cm = null;

        if (NewProductCommand.COMMNAME.equalsIgnoreCase(words[0])) {
            cm = new NewProductCommand(setting);
        }else if (PurchaseCommand.COMMNAME.equalsIgnoreCase(words[0])) {
            cm = new PurchaseCommand(setting);
        }else if (DemandCommand.COMMNAME.equalsIgnoreCase(words[0])) {
            cm = new DemandCommand(setting);
        }else if (SalesReportCommand.COMMNAME.equalsIgnoreCase(words[0])) {
            cm = new SalesReportCommand(setting);
        } if (CloseCommand.COMMNAME.equalsIgnoreCase(words[0])) {
            cm = new CloseCommand(setting);
        }



        return cm;
    }




}
