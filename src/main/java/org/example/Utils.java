package org.example;

import com.google.gson.Gson;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
    public static void writeData(User user) {
        try {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("src/data/userData.json"));
            gson.toJson(user, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static User readData() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/data/userData.json"));
            return new Gson().fromJson(reader, User.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
