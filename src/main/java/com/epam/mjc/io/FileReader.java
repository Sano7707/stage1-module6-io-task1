package com.epam.mjc.io;

import java.io.File;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder s = new StringBuilder();
        try (java.io.FileReader fr = new java.io.
                FileReader(file)) {
            int i;
            while ((i = fr.read()) != -1) {
                s.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        String[] parts = s.toString().split("[:,\n]");
        String name = parts[1].trim();
        int age = Integer.parseInt(parts[3].trim());
        String email = parts[5].trim();
        long phine = Long.parseLong(parts[7].trim());
        return new Profile(name, age, email, phine);
    }
}