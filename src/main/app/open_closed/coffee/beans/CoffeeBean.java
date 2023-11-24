package open_closed.coffee.beans;


public class CoffeeBean implements Coffee{
    private String name;
    private int quantity;

    public CoffeeBean(String name, int quantity) {

        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
