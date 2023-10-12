package domain.patterns.decorator;

import domain.models.*;

public class ShippingDecorator extends ShoppingCartDecorator {
    private double shippingCost;

    public ShippingDecorator(ShoppingCartInterface decoratedCart, double shippingCost) {
        super(decoratedCart);
        this.shippingCost = shippingCost;
    }

    public double calculateTotal() {
        return decoratedCart.calculateTotal() + shippingCost;
    }

    public double getShippingCost() {
        return shippingCost;
    }
}