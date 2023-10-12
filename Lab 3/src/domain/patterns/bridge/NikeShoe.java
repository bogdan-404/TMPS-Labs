package domain.patterns.bridge;

public class NikeShoe extends Shoe {
    public NikeShoe(Manufacturer manufacturer, String model, String size, String colour, String material, int stock,
            double price) {
        super(manufacturer, model, size, colour, material, stock, price, "Sizes may be smaller");
    }
}