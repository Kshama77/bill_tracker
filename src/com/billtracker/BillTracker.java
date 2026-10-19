package com.billtracker;

import java.util.ArrayList;
import java.util.Scanner;

public class BillTracker {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Bill> bills = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("================================");
        System.out.println("       WELCOME TO BILLTRACKER");
        System.out.println("================================");

        while (running) {
            showMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    addBill();
                    break;
                case 2:
                    viewBills();
                    break;
                case 3:
                    markBillPaid();
                    break;
                case 4:
                    showSummary();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thanks for using BillTracker. Goodbye!");
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 5.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\\n------------- MENU -------------");
        System.out.println("1. Add a bill");
        System.out.println("2. View all bills");
        System.out.println("3. Mark a bill as paid");
        System.out.println("4. View monthly summary");
        System.out.println("5. Exit");
    }

    private static void addBill() {
        System.out.print("Enter bill name (e.g., Electricity): ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Bill name cannot be empty.");
            return;
        }

        double amount = readDouble("Enter bill amount: $");
        if (amount < 0) {
            System.out.println("Amount cannot be negative.");
            return;
        }

        System.out.print("Enter due date (e.g., 2026-10-25): ");
        String dueDate = scanner.nextLine().trim();

        if (dueDate.isEmpty()) {
            System.out.println("Due date cannot be empty.");
            return;
        }

        bills.add(new Bill(name, amount, dueDate));
        System.out.println("Bill added successfully!");
    }

    private static void viewBills() {
        if (bills.isEmpty()) {
            System.out.println("No bills yet. Add a bill to get started.");
            return;
        }

        System.out.println("\\n---------------- YOUR BILLS ----------------");
        for (int i = 0; i < bills.size(); i++) {
            System.out.println((i + 1) + ". " + bills.get(i));
        }
    }

    private static void markBillPaid() {
        if (bills.isEmpty()) {
            System.out.println("There are no bills to update.");
            return;
        }

        viewBills();
        int billNumber = readInt("Enter the bill number to mark as paid: ");

        if (billNumber < 1 || billNumber > bills.size()) {
            System.out.println("Invalid bill number.");
            return;
        }

        Bill bill = bills.get(billNumber - 1);
        bill.markPaid();
        System.out.println(bill.getName() + " marked as paid.");
    }

    private static void showSummary() {
        double total = 0;
        double paid = 0;
        double unpaid = 0;
        int paidCount = 0;
        int unpaidCount = 0;

        for (Bill bill : bills) {
            total += bill.getAmount();
            if (bill.isPaid()) {
                paid += bill.getAmount();
                paidCount++;
            } else {
                unpaid += bill.getAmount();
                unpaidCount++;
            }
        }

        System.out.println("\\n--------- MONTHLY SUMMARY ---------");
        System.out.printf("Total bills:       %d%n", bills.size());
        System.out.printf("Paid bills:        %d ($%.2f)%n", paidCount, paid);
        System.out.printf("Unpaid bills:      %d ($%.2f)%n", unpaidCount, unpaid);
        System.out.printf("Total bill amount: $%.2f%n", total);
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount, such as 49.99.");
            }
        }
    }
}
