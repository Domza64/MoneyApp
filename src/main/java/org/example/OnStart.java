package org.example;

import java.io.File;
import java.util.Scanner;

public class OnStart {
    public static User start() {
        if (findJSON()) {
            return loadJSON();
        }
        return createNewUser();
    }


    private static User loadJSON() {
        return Utils.readData();
    }

    private static User createNewUser() {
        System.out.print("Type new user name: ");
        Scanner scanner = new Scanner(System.in);
        User user = new User(scanner.next());
        Utils.writeData(user);
        return user;
    }

    private static boolean findJSON() {
        File userDir = new File(System.getProperty("user.dir"));
        File file = new File(userDir, "/src/data/userData.json");
        if(file.exists() && !file.isDirectory()) {
            return true;
        }
        else {
            System.out.println("No user found, create new user.");
            return false;
        }
    }
}
