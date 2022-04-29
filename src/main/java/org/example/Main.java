package org.example;

import java.util.Scanner;

public class Main {
    private static User user;

    public static void main(String[] args) {
        user = OnStart.start();
        forTesting();
    }

    private static void printMenu() {
        System.out.println("""
                            ------------------------
                            1 - Print categories
                            2 - Print transactions
                            3 - Add category
                            4 - Add transaction
                            10 - Exit""");
        System.out.print("Enter your choice: ");
    }

    // As the name says this method is for testing code in terminal
    // It will be replaced with GUI in future
    private static void forTesting() {
        Scanner scanner = new Scanner(System.in);
        boolean shouldExit = false;
        int number;
        printMenu();
        while(!shouldExit) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
            }
            else {
                scanner.next();
                number = -1;
            }
            switch (number) {
                case 1 -> {
                    user.printCategories();
                    printMenu();
                }
                case 2 -> {
                    System.out.print("Enter category to print transactions for: ");
                    user.printTransactions(scanner.next());
                    printMenu();
                }
                case 3 -> {
                    System.out.print("Enter category name: ");
                    user.addCategory(scanner.next());
                    printMenu();
                }
                case 4 -> {
                    System.out.print("Enter category to add transactions to: ");
                    String category = scanner.next();
                    if (user.hasCategory(category)) {
                        System.out.print("Enter amount: ");
                        double amount;
                        if (scanner.hasNextDouble()) {
                            amount = scanner.nextDouble();
                        } else {
                            System.out.println("NOT A NUMBER!");
                            printMenu();
                            scanner.next();
                            break;
                        }
                        user.addTransaction(category, amount);
                        printMenu();
                        break;
                    }
                    System.out.println("CATEGORY DOES NOT EXIST");
                    printMenu();
                }
                case 10 -> {
                    System.out.println("EXITING");
                    shouldExit = true;
                }
                default -> {
                    System.out.println("WRONG INPUT");
                    printMenu();
                }
            }
        }
    }
}