package domain.patterns.bridge;

public class USManufacturer implements Manufacturer {
    @Override
    public int getWarrantyMonths() {
        return 6; 
    }
}