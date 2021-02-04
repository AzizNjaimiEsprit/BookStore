package tn.esprit.BookStore.model;

import java.util.Random;

public class CouponCodeGenerator {
    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#*()-=+|<>/?";

    public String generateCode () {
        Random rand = new Random();
        int size = rand.nextInt(10) + 5;
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) chars[i] = characters.charAt(rand.nextInt(characters.length()));
        return new String(chars);
    }
}
