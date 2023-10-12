package domain.patterns.adapter;


public interface PaymentProcessor {
    void pay(String name, String details, double amount);
    String getType();
}