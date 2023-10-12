package domain.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements ShoppingCartInterface {
    private List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(CartItem item) {
        items.add(item);
    }

    @Override
    public double calculateTotal() {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.getShoe().getPrice() * item.getQuantity();
            item.getShoe().decreaseStock(item.getQuantity());
        }
        return total;
    }
}