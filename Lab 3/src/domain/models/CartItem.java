package domain.models;

import domain.patterns.bridge.Shoe;

public class CartItem {
    private Shoe shoe;
    private int quantity;

    public CartItem(Shoe shoe, int quantity) {
        this.shoe = shoe;
        this.quantity = quantity;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}