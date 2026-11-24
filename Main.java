package com.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        
        String from = chooseCurrency(scanner, getAvailableCurrencies(), "Choose FROM currency:");
        String to = chooseCurrency(scanner, getAvailableCurrencies(), "Choose TO currency:");
    }

    public static List<String> getAvailableCurrencies() {
        return Arrays.asList("USD", "EUR", "GBP");
    }

    public static String chooseCurrency(Scanner scanner, List<String> currencies, String message) {
        System.out.println(message);

        for (int i = 0; i < currencies.size(); i++) {
            System.out.println((i + 1) + ". " + currencies.get(i));
        }

        int choice = scanner.nextInt();
        return currencies.get(choice - 1);
    }
}