package domain.patterns.bridge;

public class ChinaManufacturer implements Manufacturer {
    @Override
    public int getWarrantyMonths() {
        return 3;
    }
}