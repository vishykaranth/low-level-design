package open_closed.coffee;

public class Configuration {
    private int quantityWater;
    private int quantityCoffee;

    public Configuration(int quantityCoffee, int quantityWater) {

        this.quantityCoffee = quantityCoffee;
        this.quantityWater = quantityWater;
    }

    public int getQuantityWater() {
        return quantityWater;
    }

    public void setQuantityWater(int quantityWater) {
        this.quantityWater = quantityWater;
    }

    public int getQuantityCoffee() {
        return quantityCoffee;
    }

    public void setQuantityCoffee(int quantityCoffee) {
        this.quantityCoffee = quantityCoffee;
    }
}
