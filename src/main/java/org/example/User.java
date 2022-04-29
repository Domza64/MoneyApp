package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String profileName;
    private List<Category> categories;

    public User(String profileName) {
        this.profileName = profileName;
        categories = new ArrayList<>();
    }

    public boolean addCategory(String name) {
        Category category = new Category(name);
        if (!categories.contains(category)) {
            categories.add(category);
            Utils.writeData(this);
            return true;
        }
        else return false;
    }

    public boolean addTransaction(String category, double amount, String description) {
        Category category1 = findCategory(category);
        if (category1 != null) {
            Transaction transaction = new Transaction(amount, description);
            category1.addTransaction(transaction);
            Utils.writeData(this);
            return true;
        }
        return false;
    }


    public boolean addTransaction(String category, double amount) {
        return addTransaction(category, amount, "");
    }

    public void printCategories() {
        System.out.println(profileName + "'s categories:");
        for (Category category : categories) {
            System.out.println(" - " + category);
        }
    }

    public void printTransactions(String category) {
        Category category1 = findCategory(category);
        if (category1 != null) {
            System.out.println("'" + category + "'" + " transactions:");
            for (Transaction transaction : category1.getTransactions()) {
                System.out.println(" - " + transaction);
            }
        }
        else {
            System.out.println("Category '" + category + "' does not exist.");
        }
    }

    private Category findCategory(String category) {
        // Should probably implement comparable in category or something like that for more efficient searching.
        for (Category category1 : categories) {
            if (category1.getName().equals(category)) {
                return category1;
            }
        }
        return null;
    }

    public boolean hasCategory(String category) {
        return findCategory(category) != null;
    }
}
