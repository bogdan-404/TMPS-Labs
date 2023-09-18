import java.util.Scanner;

import domain.api.*;
import domain.utils.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose how to generate the IP address:");
        System.out.println("1. Get my actual IP address");
        System.out.println("2. Generate a random IP address");
        int choice = scanner.nextInt();

        if (choice == 1) {
            DisplayInformation displayInformation = new DisplayInformation(
                    new IpAddressGeneratorConstructor(new IpifyApi("https://api.ipify.org?format=json")),
                    new IpinfoApi("https://ipinfo.io/"));
            displayInformation.run();

        } else if (choice == 2) {
            DisplayInformation displayInformation = new DisplayInformation(
                    new IpAddressGeneratorConstructor(new IpAddressRandomGenerator()),
                    new IpinfoApi("https://ipinfo.io/"));
            displayInformation.run();
        } else {
            System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}
