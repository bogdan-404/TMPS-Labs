package domain.patterns.decorator;

import domain.models.*;

public abstract class ShoppingCartDecorator {
    public ShoppingCartInterface decoratedCart;

    public ShoppingCartDecorator(ShoppingCartInterface decoratedCart) {
        this.decoratedCart = decoratedCart;
    }

    public double calculateTotal() {
        return decoratedCart.calculateTotal();
    }
}
