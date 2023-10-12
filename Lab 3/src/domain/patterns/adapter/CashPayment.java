package domain.patterns.adapter;

import domain.models.Database;

public class CashPayment implements PaymentProcessor {
    private String type = "cash";

    @Override
    public void pay(String name, String surname, double amount) {
        String paymentRecord = name + " " + surname + " will pay $" + amount + " in cash.";
        Database.addTransaction(paymentRecord);
    }

    @Override
    public String getType() {
        return this.type;
    }
}
