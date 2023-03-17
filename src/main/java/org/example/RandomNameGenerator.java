package org.example;

import java.util.Random;


public interface RandomNameGenerator {

    public static String randomGeneratorEmail (){
        String emailone = generateRandomString(8) +"@yan.ru";
        return emailone;
    }

    public static String generateRandomUsername(){

        return generateRandomString(10);
    }
    private static String generateRandomString(int lent){
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < lent; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}
