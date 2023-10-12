package domain.patterns.decorator;

import domain.models.*;

public class DiscountDecorator extends ShoppingCartDecorator {
    private double discountRate;

    public DiscountDecorator(ShoppingCartInterface decoratedCart, double discountRate) {
        super(decoratedCart);
        this.discountRate = discountRate;
    }

    public double calculateTotal() {
        return decoratedCart.calculateTotal() * (1 - discountRate);
    }

    public double getDiscount() {
        return discountRate;
    }
}