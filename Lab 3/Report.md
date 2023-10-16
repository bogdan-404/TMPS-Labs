# Structural Design Patterns

## Author: Zlatovcen Bogdan

---

## Objectives:

- Study and understand the Structural Design Patterns

- Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.

- Use some structural design patterns for object instantiation in a sample project.

## Implementation

### Adapter Pattern

We have the `CashPayment` class which implements the `PaymentProcessor` interface:

```java
public interface PaymentProcessor {
    void pay(String name, String details, double amount);
    String getType();
}
```

The class `CardPaymentGateway` is incompatible with the `PaymentProcessor` interface, because it takes different arguments for the `processPayment` method (or the `pay` method):

```java
public void processPayment(String cardHolderName, String cardNumber, double amount,String expiryDate)
        throws ParseException {
    if (isExpiryDateValid(expiryDate)) {
        String paymentRecord = cardHolderName + " paid $" + amount + " using cardnumber ending in " + cardNumber.substring(cardNumber.length() - 4);
        Database.addTransaction(paymentRecord);
    } else {
        System.out.println("Card expired. Transaction failed.");
    }
}
```

Thus, we create the `CardPaymentGatewayAdapter` class which implements the `PaymentProcessor` interface and has a `CardPaymentGateway` object as a field. The `CardPaymentGatewayAdapter` class adapts the `CardPaymentGateway` class to the `PaymentProcessor` interface:

```java
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
```

where `gateway` is the `CardPaymentGateway` object.

### Bridge Pattern

`Shoe` class is the abstraction that maintains a reference to `Manufacturer` class, which is the implementor.

```java
public abstract class Shoe implements Product {
    protected Manufacturer manufacturer;

    public Shoe(Manufacturer manufacturer, ...) {
        this.manufacturer = manufacturer;
        this.warrantyMonths = manufacturer.getWarrantyMonths();
    ...
}
```

The classes which extend the implementor are `USManufacturer` and `ChinaManufacturer`, and are the concrete implemenntors.

`AdidasShoe` and `NikeShoe` classes are concrete abstractions, which means that they extend the `Shoe` abstraction and can have different behaviors or attributes specific to each brand, while still maintaining a reference to the `Manufacturer`.

In the `Main` class here is how we define an object using the bridge pattern:

```java
Shoe nikeShoe = new NikeShoe(new ChinaManufacturer(), "AirMax", "9", "Blue", "Canvas", 150, 80.0);
```

### Decorator Pattern

We use `DiscountDecorator` and `ShippingDecorator` classes to add new functionalities to the `Cart` class. Both these classes extend the `SHoppingCartDecorator` class, which is the abstract decorator:

```java
public abstract class ShoppingCartDecorator {
    public ShoppingCartInterface decoratedCart;

    public ShoppingCartDecorator(ShoppingCartInterface decoratedCart) {
        this.decoratedCart = decoratedCart;
    }

    public double calculateTotal() {
        return decoratedCart.calculateTotal();
    }
}
```

The `DiscountDecorator` class adds a discount to the total price of the cart:

```java
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
```

The `ShippingDecorator` class adds a shipping cost to the total price of the cart:

```java
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
```

### Facade Pattern

`OrderFacade` acts as the main interface for clients. The client doesn't need to know about the `ShoppingCart`, `DiscountDecorator`, `ShippingDecorator`, and `Order` classes or how they interact. The client simply uses the placeOrder method to make an order.

## Conclusion

In this lab, we explored structural design patterns, including the Adapter, Bridge, Decorator, and Facade patterns, each addressing unique software design challenges. Through practical implementation, we observed how these patterns promote code reusability, and simplify complex systems. By using these design principles, we can create more maintainable, flexible, and organized code structure.
