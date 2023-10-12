package domain.patterns.adapter;

import java.text.ParseException;

public class PaymentAdapter implements PaymentProcessor {
    private String type = "card";
    private CardPaymentGateway gateway;

    public PaymentAdapter(CardPaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(String name, String details, double amount) {
        String[] cardDetails = details.split("/");
        String cardNumber = cardDetails[0].trim();
        String expiryDate = cardDetails.length > 1 ? cardDetails[1].trim() : "";
        try {
            gateway.processPayment(name, cardNumber, amount, expiryDate);
        } catch (ParseException e) {
            System.out.println("Error processing payment: " + e.getMessage());
        }
    }

    @Override
    public String getType() {
        return this.type;
    }
}