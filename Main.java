package com.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> rates = getRates();
        List<String> currencies = getAvailableCurrencies(rates);

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        String from = chooseCurrency(scanner, getAvailableCurrencies(rates), "Choose FROM currency:");
        String to = chooseCurrency(scanner, getAvailableCurrencies(rates), "Choose TO currency:");

        double convertedAmount = convertCurrency(amount, from, to, rates);
        String result = formatConversionResult(amount, from, convertedAmount, to);
        System.out.println(result);
    }

    public static Map<String, Double> getRates() {
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("EUR", 0.9);
        rates.put("GBP", 0.8);
        return rates;
    }

    public static List<String> getAvailableCurrencies(Map<String, Double> rates) {
        return new ArrayList<>(rates.keySet());
    }

    public static String chooseCurrency(Scanner scanner, List<String> currencies, String message) {
        System.out.println(message);
        for (int i = 0; i < currencies.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, currencies.get(i));
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return currencies.get(choice - 1);
    }

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency, Map<String, Double> rates) {
        double fromRate = rates.get(fromCurrency);
        double toRate = rates.get(toCurrency);
        return amount / fromRate * toRate;
    }

    // New logic for formatting the result
    public static String formatConversionResult(double amount, String fromCurrency, double convertedAmount, String toCurrency) {
        return String.format("%.2f %s is equal to %.2f %s.", amount, fromCurrency, convertedAmount, toCurrency);
    }
}