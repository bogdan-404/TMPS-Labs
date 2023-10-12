package domain.models;

import java.util.ArrayList;
import java.util.List;
import domain.patterns.bridge.Shoe;

public class Database {
    private static List<Shoe> shoes = new ArrayList<>();
    private static List<String> transactions = new ArrayList<>();

    public static void addShoe(Shoe shoe) {
        shoes.add(shoe);
        displayNewRecord("New shoe added: " + shoe.getDescription());
    }

    public static void addTransaction(String transaction) {
        transactions.add(transaction);
        displayNewRecord("New transaction: " + transaction);
    }

    public static List<Shoe> getShoes() {
        return shoes;
    }

    private static void displayNewRecord(String record) {
        System.out.println(record);
    }
}