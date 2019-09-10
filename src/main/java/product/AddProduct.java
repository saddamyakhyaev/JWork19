package product;

import java.util.Date;

public class AddProduct {

    private int id;
    private int price;
    private int priceDemand;
    private Date datePurchase;
    private Date dateDemand;

    public AddProduct(int id, int price, Date datePurchase) {
        this.id = id;
        this.price = price;
        this.datePurchase = datePurchase;
        dateDemand = null;
    }

    public void demand(int priceDemand, Date dateDemand){
        this.priceDemand = priceDemand;
        this.dateDemand = dateDemand;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getPriceDemand() { return priceDemand; }

    public Date getDatePurchase() {
        return datePurchase;
    }

    public Date getDateDemand() {
        return dateDemand;
    }
}
