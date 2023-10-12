package domain.patterns.facade;

import domain.models.*;
import domain.patterns.bridge.*;
import domain.patterns.decorator.DiscountDecorator;
import domain.patterns.decorator.ShippingDecorator;
import domain.patterns.adapter.*;

public class OrderFacade {
    public void placeOrder(Shoe shoe, int quantity, PaymentProcessor paymentProcessor, String paymentDetails) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem(shoe, quantity));

        var discountCart = new DiscountDecorator(cart, 0.05);
        var shippingCart = new ShippingDecorator(cart, 10.0);

        System.out.println("Original cost: $" + cart.calculateTotal());
        System.out.println("Cost with shipping: $" + shippingCart.calculateTotal());
        System.out.println("Cost with discount (without shipping): $" + discountCart.calculateTotal());

        Order order = new Order(cart, paymentProcessor, paymentDetails,
                shippingCart.getShippingCost(), discountCart.getDiscount());
        order.processOrder();
    }
}
