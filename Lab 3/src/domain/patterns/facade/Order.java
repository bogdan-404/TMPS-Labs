package domain.patterns.facade;

import domain.models.*;
import domain.patterns.adapter.PaymentProcessor;

public class Order {
    private ShoppingCart cart;
    private PaymentProcessor paymentProcessor;
    private String paymentDetails;
    private double shippingCost;
    private double discount;

    public Order(ShoppingCart cart, PaymentProcessor paymentProcessor, String paymentDetails, double shippingCost,
            double discount) {
        this.cart = cart;
        this.paymentProcessor = paymentProcessor;
        this.paymentDetails = paymentDetails;
        this.shippingCost = shippingCost;
        this.discount = discount;
    }

    public void processOrder() {
        double total = (cart.calculateTotal() * (1 - this.discount)) + this.shippingCost;
        System.out.println("Cost with shipping and discount: " + total);
        String name = "";
        String details = "";
        if (paymentProcessor.getType().equals("cash")) {
            String[] paymentInfo = paymentDetails.split(" ");
            name = paymentInfo[0].trim();
            details = paymentInfo[1].trim();
        } else {
            String[] paymentInfo = paymentDetails.split("/");
            name = paymentInfo[0].trim();
            String cardNumber = paymentInfo[1].trim();
            String expiryDate = paymentInfo[2].trim();
            System.out.println(paymentInfo);
            details = cardNumber;
            if (!expiryDate.isEmpty()) {
                details += "/" + expiryDate;
            }
        }
        paymentProcessor.pay(name, details, total);
    }

}