package product;

public class TestClassProductSetting {

    String name;
    int amount;
    int price;
    String date;

    public TestClassProductSetting(String name, int amount, int price, String date) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }
}
