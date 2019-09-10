package commands;

import product.ProductsManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public abstract class Command {

    public String nameProduct;

    private String[] settingsC;
    //public String nameCommand;
    //public String dateCommand;

    protected String returnWork;

    public boolean close_p = false;


    public Command(String settings) {
        settingsC = settings.replaceAll("[\\s]{2,}", " ").split(" ");
    }

    public boolean idDateValid(String _date) {

        if(!Pattern.matches("(0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[012]).((19|20)\\d\\d)", _date)) return false;
        try {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            df.setLenient(false);
            df.parse(_date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public String getSetting(int order){
        if(order < 0 || (order + 1) > settingsC.length) return null;
        return settingsC[order];
    }
    public int getCountSetting(){ return (settingsC.length - 1);}

    public abstract String work(ProductsManager products);

    public String trueWork(){ return "OK"; }
    public String errorWork(){ return "ERROR"; }

    public void close(){ close_p = true;}
    public boolean isClose(){ return close_p;}

}
