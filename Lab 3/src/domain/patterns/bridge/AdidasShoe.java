package domain.patterns.bridge;

public class AdidasShoe extends Shoe {
    public AdidasShoe(Manufacturer manufacturer, String model, String size, String colour, String material, int stock,
            double price) {
        super(manufacturer, model, size, colour, material, stock, price, "Sizes usually come larger");
    }
}