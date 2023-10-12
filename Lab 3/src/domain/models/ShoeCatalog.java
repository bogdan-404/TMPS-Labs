package domain.models;

import domain.patterns.bridge.Shoe;
import java.util.ArrayList;
import java.util.List;

public class ShoeCatalog {
    private List<Shoe> shoes;

    public ShoeCatalog() {
        this.shoes = new ArrayList<>();
    }

    public void addShoe(Shoe shoe) {
        shoes.add(shoe);
    }

    public List<Shoe> getShoes() {
        return shoes;
    }
}
