package product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProductsManager {

    ArrayList<Product> products;
    ArrayList<AddProduct> addProducts;

    public ProductsManager() {
        products = new ArrayList<Product>();
        addProducts = new ArrayList<AddProduct>();
    }

    public boolean newProduct(String _productName){
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().equals(_productName)) return false;
        }

        products.add(new Product(products.size(), _productName));
        return true;
    }

    public boolean addProduct(String name, int amount, int price, String date){

        int id_product = getIdProduct(name);
        if(id_product == -1) return false;

        for(int j = 0; j < amount; j++) {
            Date date_l = null;
            try {
                date_l = new SimpleDateFormat("dd.MM.yyyy").parse(date);
            } catch (ParseException e) {
                return false;
            }
            addProducts.add(new AddProduct(id_product,price, date_l));
        }

        return true;
    }

    public boolean demandProduct(String name, int amount, int price, String date){

        int id_product = getIdProduct(name);
        if(id_product == -1) return false;

        Date date_search = null;
        try {
            date_search = new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            return false;
        }

        ArrayList<AddProduct> addProducts_list = new ArrayList<AddProduct>();
        for (int i = 0, count = 0; i < addProducts.size(); i++) {
            AddProduct pr = addProducts.get(i);
            if (pr.getId() == id_product && pr.getDateDemand() == null &&
             (pr.getDatePurchase().compareTo(date_search) < 0 || pr.getDatePurchase().compareTo(date_search) == 0)) {
                addProducts_list.add(pr);
                count++;
                if(count == amount) break;
            }
        }

        if(addProducts_list.size() == amount)
            for (int i = 0; i < addProducts_list.size(); i++) {
                    AddProduct pr = addProducts_list.get(i);
                    Date date_l = null;
                    try {
                        date_l = new SimpleDateFormat("dd.MM.yyyy").parse(date);
                    } catch (ParseException e) {
                        return false;
                    }
                    pr.demand(price, date_l);

                    amount--;
                    if(amount < 1) return true;
            }

      return false;
    }

    public int getIdProduct(String name){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                return products.get(i).getId();
            }
        }
        return -1;
    }

    public ArrayList<AddProduct> getDemandProducts(String name, String date){
        ArrayList<AddProduct> productsDemand = new ArrayList<AddProduct>();

        int id_product = getIdProduct(name);
        if(id_product == -1) return null;

        Date date_search = null;
        try {
            date_search = new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }

        for (int i = 0; i < addProducts.size(); i++) {
            AddProduct pr = addProducts.get(i);
            if (pr.getId() == id_product && pr.getDateDemand() != null && (pr.getDateDemand().compareTo(date_search) < 0 || pr.getDateDemand().compareTo(date_search) == 0)) {
                productsDemand.add(pr);
            }
        }
        return productsDemand;
    }

    public boolean isProduct(String _productName) {
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getName().equals(_productName)) return true;
        }

        return false;
    }


}
