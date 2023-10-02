import java.util.Scanner;

import domain.api.*;
import domain.utils.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose how to generate the IP address:");
        System.out.println("1. Get my actual IP address");
        System.out.println("2. Generate a random IP address");
        int choice = scanner.nextInt();
        String type;
        if (choice == 1) {
            type = "actual";
        } else if (choice == 2) {
            type = "random";
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        IpAddressGeneratorConstructor ipGenerator = new IpAddressGeneratorConstructor(type);
        IpInfoInterface ipInformation = new IpinfoApi("https://ipinfo.io/");
        DisplayInformation displayInformation = DisplayInformation.getInstance(ipGenerator, ipInformation);
        displayInformation.run();

        if (choice == 2) {
            System.out.println("If you still consider getting your actual IP, type 1");
            int choice2 = scanner.nextInt();
            if (choice2 == 1) {
                IpAddressGeneratorConstructor clonedGenerator = ipGenerator.clone();
                clonedGenerator.setIpGenerator("actual");
                displayInformation.setIpAddressGenerator(clonedGenerator);
                displayInformation.run();
            }
        }
        scanner.close();
    }
}