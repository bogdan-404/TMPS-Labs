package domain.patterns.bridge;

public abstract class Shoe implements Product {
    protected Manufacturer manufacturer;
    protected String model;
    protected int warrantyMonths;
    protected String size;
    protected String colour;
    protected String material;
    protected int stock;
    protected double price;
    protected String sizeGuide;

    public Shoe(Manufacturer manufacturer, String model, String size, String colour, String material, int stock,
            double price, String sizeGuide) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.size = size;
        this.colour = colour;
        this.material = material;
        this.stock = stock;
        this.price = price;
        this.sizeGuide = sizeGuide;
        this.warrantyMonths = manufacturer.getWarrantyMonths();
    }

    @Override
    public String getDescription() {
        return "Shoe [Model: " + model + ", Size: " + size + ", Colour: " + colour + ", Material: " + material + "]";
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getStock() {
        return stock;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public String getSizeGuide() {
        return sizeGuide;
    }

    public void decreaseStock(int amount) {
        this.stock -= amount;
    }
}
