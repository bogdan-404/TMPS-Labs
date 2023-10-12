package domain.patterns.adapter;

import java.text.ParseException;
import domain.models.Database;

public class CardPaymentGateway {
    private String currentDate = "01-10-2023";

    public void processPayment(String cardHolderName, String cardNumber, double amount, String expiryDate)
            throws ParseException {
        if (isExpiryDateValid(expiryDate)) {
            String paymentRecord = cardHolderName + " paid $" + amount + " using card number ending in "
                    + cardNumber.substring(cardNumber.length() - 4);
            Database.addTransaction(paymentRecord);
        } else {
            System.out.println("Card expired. Transaction failed.");
        }
    }

    private boolean isExpiryDateValid(String expiryDate) throws ParseException {
        if (expiryDate.length() != currentDate.length()) {
            return false;
        }
        for (int i = 0; i < expiryDate.length(); i++) {
            if (expiryDate.charAt(i) < currentDate.charAt(i)) {
                return false;
            } else if (expiryDate.charAt(i) > currentDate.charAt(i)) {
                return true;
            }
        }
        return true;
    }
}
