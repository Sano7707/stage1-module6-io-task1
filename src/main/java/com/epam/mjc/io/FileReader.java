package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file)  {
        StringBuilder s = new StringBuilder();
        java.io.FileReader fr = null;
        try {
            fr = new java.io.
                    FileReader(file);
            int i;
            while ((i = fr.read()) != -1) {
                s.append((char) i);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                assert fr != null;
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] parts = s.toString().split("[:,'\n']");
        String name = parts[1].trim();
        int age = Integer.parseInt(parts[3].trim());
        String email = parts[5].trim();
        long phine = Long.parseLong(parts[7].trim());
        return new Profile(name, age, email, phine);
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.getDataFromFile(new File("/Users/macbook/Desktop/stage1-module6-io-task1/src/main/resources/Profile.txt"));
    }
}