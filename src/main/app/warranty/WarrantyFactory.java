package warranty;

public class WarrantyFactory {
    public static Warranty createWarranty(String merchant) {
        return new Warranty(merchant);
    }
}
