package com.billtracker;

public class Bill {
    private String name;
    private double amount;
    private String dueDate;
    private boolean paid;

    public Bill(String name, double amount, String dueDate) {
        this.name = name;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paid = false;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void markPaid() {
        paid = true;
    }

    public void markUnpaid() {
        paid = false;
    }

    @Override
    public String toString() {
        String status = paid ? "Paid" : "Unpaid";
        return String.format("%-20s $%8.2f   Due: %-12s Status: %s",
                name, amount, dueDate, status);
    }
}
