package com.example.madt_lab2.utilities;

public class TextCounting {

    public static int getCharsCount(String userPhrase) {
        return userPhrase.length();
    }

    public static int getWordsCount(String userPhrase) {
        String text = userPhrase.trim();
        //Split the text by one or more spaces and insert it into an array of strings
        String[] words = text.split("\\s+");
        return words.length;
    }
}
