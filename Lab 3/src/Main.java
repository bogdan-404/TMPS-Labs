import domain.models.*;
import domain.patterns.bridge.*;
import domain.patterns.facade.*;
import domain.patterns.adapter.*;

public class Main {
    public static void main(String[] args) {
        Shoe adidasShoe = new AdidasShoe(new USManufacturer(), "UltraBoost", "10", "Red", "Leather", 100, 120.0);
        Database.addShoe(adidasShoe);

        Shoe nikeShoe = new NikeShoe(new ChinaManufacturer(), "AirMax", "9", "Blue", "Canvas", 150, 80.0);
        Database.addShoe(nikeShoe);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem(adidasShoe, 2));

        PaymentProcessor cashPayment = new CashPayment();
        OrderFacade facade = new OrderFacade();
        facade.placeOrder(adidasShoe, 2, cashPayment, "John Doe");

        PaymentAdapter cardPayment = new PaymentAdapter(new CardPaymentGateway());
        facade.placeOrder(nikeShoe, 3, cardPayment, "Jane Smith/1234-5678-9012-3456/03-10-2025");
    }
}
